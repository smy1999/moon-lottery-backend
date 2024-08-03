package com.moon.lottery.domain.activity.service.partake;

import com.alibaba.fastjson.JSON;
import com.moon.lottery.common.Constants;
import com.moon.lottery.common.Result;
import com.moon.lottery.domain.activity.model.req.PartakeReq;
import com.moon.lottery.domain.activity.model.res.PartakeResult;
import com.moon.lottery.domain.activity.model.vo.ActivityBillVO;
import com.moon.lottery.domain.support.ids.IIdGenerator;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/6/16
 */
@Slf4j
public abstract class BaseActivityPartake extends ActivityPartakeSupport implements IActivityPartake {

    @Resource
    private Map<Constants.Ids, IIdGenerator> idGeneratorMap;

    @Override
    public PartakeResult doPartake(PartakeReq req) {

        log.info("Partake activity begin, activityId: {}, uId: {}", req.getActivityId(), req.getActivityId());

        // todo
        // 1. 查询是否存在未执行抽奖领取活动单【user_take_activity 存在 state = 0，领取了但抽奖过程失败的，可以直接返回领取结果继续抽奖】
        UserTakeActivityVO userTakeActivityVO = this.queryNoConsumedTakeActivityOrder(req.getActivityId(), req.getuId());
        if (null != userTakeActivityVO) {
            return buildPartakeResult(userTakeActivityVO.getStrategyId(), userTakeActivityVO.getTakeId());
        }

        // 1. 查询活动账单
        ActivityBillVO activityBillVO = super.queryActivityBill(req);

        // 2. 校验活动信息(日期,状态,个人次数,活动库存)
        Result check = this.checkActivityBill(req, activityBillVO);
        if (!Constants.ResponseCode.SUCCESS.getCode().equals(check.getCode())) {
            return new PartakeResult(check.getCode(), check.getInfo());
        }

        // 3. 扣减活动库存(暂时使用 lottery.activity 表减库存,后续使用Redis)
        Result subtract = this.subtractActivityStock(req);
        if (!Constants.ResponseCode.SUCCESS.getCode().equals(subtract.getCode())) {
            return new PartakeResult(subtract.getCode(), subtract.getInfo());
        }

        // 4. 领取活动信息(活动信息写入用户表)
        Long takeId = idGeneratorMap.get(Constants.Ids.SNOWFLAKE).nextId();
        Result grab = this.grabActivity(req, activityBillVO, takeId);
        if (!Constants.ResponseCode.SUCCESS.getCode().equals(grab.getCode())) {
            return new PartakeResult(grab.getCode(), grab.getInfo());
        }
        // 5. 封装结果
        log.info("Partake activity end, activityId: {}, uId: {}, takeId: {}", req.getActivityId(), req.getActivityId(), takeId);
        return this.buildPartakeResult(activityBillVO.getStrategyId(), takeId);

    }

    /**
     * 校验活动信息(日期,状态,个人次数,活动库存)
     * @param req
     * @param activityBillVO
     * @return
     */
    protected abstract Result checkActivityBill(PartakeReq req, ActivityBillVO activityBillVO);

    /**
     * 扣减活动库存,目前操作lottery.activity,后续用Redis
     * @param req
     * @return
     */
    protected abstract Result subtractActivityStock(PartakeReq req);

    /**
     * 用户领取活动,用户信息写入用户表
     *
     * @param req
     * @param activityBillVO
     * @param takeId
     * @return
     */
    protected abstract Result grabActivity(PartakeReq req, ActivityBillVO activityBillVO, Long takeId);


    /**
     * 封装结果
     *
     * @param strategyId
     * @param takeId
     * @return
     */
    private PartakeResult buildPartakeResult(Long strategyId, Long takeId) {
        PartakeResult partakeResult = new PartakeResult(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo());
        partakeResult.setTakeId(takeId);
        partakeResult.setStrategyId(strategyId);
        return partakeResult;
    }
}
