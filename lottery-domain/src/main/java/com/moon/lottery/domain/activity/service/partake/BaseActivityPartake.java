package com.moon.lottery.domain.activity.service.partake;

import com.alibaba.fastjson.JSON;
import com.moon.lottery.common.Constants;
import com.moon.lottery.common.Result;
import com.moon.lottery.domain.activity.model.req.PartakeReq;
import com.moon.lottery.domain.activity.model.res.PartakeResult;
import com.moon.lottery.domain.activity.model.vo.ActivityBillVO;
import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/6/16
 */
@Slf4j
public abstract class BaseActivityPartake extends ActivityPartakeSupport implements IActivityPartake {

    @Override
    public PartakeResult doPartake(PartakeReq req) {

        log.info("Partake activity begin, activityId: {}, uId: {}", req.getActivityId(), req.getActivityId());

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
        Result grab = this.grabActivity(req, activityBillVO);
        if (!Constants.ResponseCode.SUCCESS.getCode().equals(grab.getCode())) {
            return new PartakeResult(grab.getCode(), grab.getInfo());
        }
        // 5. 封装结果
        PartakeResult partakeResult = new PartakeResult(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo());
        partakeResult.setStrategyId(activityBillVO.getStrategyId());
        log.info("Partake activity end, activityId: {}, uId: {}, partakeResult: {}", req.getActivityId(), req.getActivityId(), JSON.toJSONString(partakeResult));

        return partakeResult;
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
     * @param req
     * @param activityBillVO
     * @return
     */
    protected abstract Result grabActivity(PartakeReq req, ActivityBillVO activityBillVO);
}
