package com.moon.lottery.domain.activity.service.partake.impl;

import com.moon.lottery.domain.activity.repository.IUserTakeActivityCountRepository;
import com.moon.lottery.domain.activity.repository.IUserTakeActivityRepository;
import com.moon.lottery.domain.support.ids.IIdGenerator;
import com.moon.middleware.db.router.strategy.IDBRouterStrategy;
import com.moon.lottery.common.Constants;
import com.moon.lottery.common.Result;
import com.moon.lottery.domain.activity.model.req.PartakeReq;
import com.moon.lottery.domain.activity.model.vo.ActivityBillVO;
import com.moon.lottery.domain.activity.service.partake.BaseActivityPartake;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import java.util.DuplicateFormatFlagsException;
import java.util.Map;
import java.util.Objects;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/6/17
 */
@Slf4j
@Service
public class ActivityPartakeImpl extends BaseActivityPartake {

    @Resource
    private Map<Constants.Ids, IIdGenerator> idGeneratorMap;

    @Resource
    private IUserTakeActivityRepository userTakeActivityRepository;

    @Resource
    private IUserTakeActivityCountRepository userTakeActivityCountRepository;

    @Resource
    private TransactionTemplate transactionTemplate;

    @Resource
    private IDBRouterStrategy dbRouter;

    @Override
    protected Result checkActivityBill(PartakeReq req, ActivityBillVO activityBillVO) {

        if (!Constants.ActivityState.EXECUTE.getCode().equals(activityBillVO.getState())) {
            log.warn("Illegal activity state: {}", activityBillVO.getState());
            return Result.buildErrorResult("Illegal activity state.");
        }
        if (req.getPartakeDate().isBefore(activityBillVO.getBeginDateTime()) || req.getPartakeDate().isAfter(activityBillVO.getEndDateTime())) {
            log.warn("Illegal partake time: {}", req.getPartakeDate());
            return Result.buildErrorResult("Illegal partake time.");
        }
        if (activityBillVO.getStockSurplusCount() <= 0) {
            log.warn("No enough activity take count: {}", activityBillVO.getStockSurplusCount());
            return Result.buildErrorResult("No enough activity take count.");
        }
        if (Objects.nonNull(activityBillVO.getUserTakeLeftCount()) && activityBillVO.getUserTakeLeftCount() <= 0) {
            log.warn("User have taken too many activities: {}", activityBillVO.getUserTakeLeftCount());
            return Result.buildErrorResult("User have taken too many activities.");
        }
        return Result.buildSuccessResult();
    }

    @Override
    protected Result subtractActivityStock(PartakeReq req) {
        int count = activityRepository.subtractActivityStock(req.getActivityId());
        if (count == 0) {
            log.error("Subtract activity stock fail.");
            return Result.buildResult(Constants.ResponseCode.NO_UPDATE);
        }
        return Result.buildSuccessResult();
    }

    @Override
    protected Result grabActivity(PartakeReq req, ActivityBillVO activityBillVO) {
        try {
            dbRouter.doRouter(String.valueOf(req.getUId()));
            return transactionTemplate.execute(status -> {

                try {
                    // 扣减个人已经参加次数
                    // 更新 user_take_activity_count 表
                    int count = userTakeActivityCountRepository.subtractLeftCount(req.getUId(), req.getActivityId(), activityBillVO.getTakeCount(), activityBillVO.getUserTakeLeftCount());
                    if (count == 0) {
                        status.setRollbackOnly();
                        log.error("Partake activity, subtract user left take count fail, activityId: {}, uId: {}", req.getActivityId(), req.getUId());
                        return Result.buildResult(Constants.ResponseCode.NO_UPDATE);
                    }

                    // 记录活动领取信息
                    // 插入 user_take_activity 表
                    Long takeId = idGeneratorMap.get(Constants.Ids.SNOWFLAKE).nextId();

                    userTakeActivityRepository.takeActivity(req.getUId(), takeId, req.getActivityId(), activityBillVO.getActivityName(), req.getPartakeDate(), activityBillVO.getTakeCount(), activityBillVO.getUserTakeLeftCount());

                } catch (DuplicateFormatFlagsException e) {
                    status.setRollbackOnly();
                    log.error("Partake activity, duplicate primary key error, activityId: {}, uId: {}", req.getActivityId(), req.getUId());
                    return Result.buildResult(Constants.ResponseCode.INDEX_DUPLICATE);
                }

                return Result.buildSuccessResult();
            });
        } finally {
            dbRouter.clear();
        }

    }
}
