package com.moon.lottery.domain.activity.service.stateflow.event;

import com.moon.lottery.common.Constants;
import com.moon.lottery.common.Result;
import com.moon.lottery.domain.activity.service.stateflow.AbstractState;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/28
 */
@Component
public class ExecuteState extends AbstractState {
    @Override
    public Result arraignment(Long activityId, Constants.ActivityState current) {
        return Result.buildErrorResult("活动中不能提审");
    }

    @Override
    public Result pass(Long activityId, Constants.ActivityState current) {
        return Result.buildErrorResult("活动中不能通过");
    }

    @Override
    public Result refuse(Long activityId, Constants.ActivityState current) {
        return Result.buildErrorResult("活动中不能拒绝");
    }

    @Override
    public Result revoke(Long activityId, Constants.ActivityState current) {
        return Result.buildErrorResult("活动中不能撤审");
    }

    @Override
    public Result close(Long activityId, Constants.ActivityState current) {
        Boolean success = activityRepository.alterStatus(activityId, current, Constants.ActivityState.CLOSE);
        if (success == Boolean.FALSE) {
            return Result.buildErrorResult("活动状态变更失败");
        }
        return Result.buildResult(Constants.ResponseCode.SUCCESS.getCode(), "审核关闭成功");
    }

    @Override
    public Result open(Long activityId, Constants.ActivityState current) {
        return Result.buildErrorResult("活动中不能开启");
    }

    @Override
    public Result execute(Long activityId, Constants.ActivityState current) {
        return Result.buildErrorResult("活动不能重复执行");
    }
}
