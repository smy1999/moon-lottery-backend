package com.moon.lottery.domain.activity.service.stateflow.event;

import com.moon.lottery.common.Constants;
import com.moon.lottery.common.Result;
import com.moon.lottery.domain.activity.service.stateflow.AbstractState;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/19
 */
@Component
public class ArraignmentState extends AbstractState {
    @Override
    public Result arraignment(Long activityId, Constants.ActivityState current) {
        return Result.buildErrorResult("不能重复提审");
    }

    @Override
    public Result pass(Long activityId, Constants.ActivityState current) {
        Boolean success = activityRepository.alterStatus(activityId, current, Constants.ActivityState.PASS);
        if (success == Boolean.FALSE) {
            return Result.buildErrorResult("活动状态变更失败");
        }
        return Result.buildResult(Constants.ResponseCode.SUCCESS.getCode(), "活动通过");
    }

    @Override
    public Result refuse(Long activityId, Constants.ActivityState current) {
        Boolean success = activityRepository.alterStatus(activityId, current, Constants.ActivityState.REFUSE);
        if (success == Boolean.FALSE) {
            return Result.buildErrorResult("活动状态变更失败");
        }
        return Result.buildResult(Constants.ResponseCode.SUCCESS.getCode(), "活动拒绝");
    }

    @Override
    public Result revoke(Long activityId, Constants.ActivityState current) {
        Boolean success = activityRepository.alterStatus(activityId, current, Constants.ActivityState.REVOKE);
        if (success == Boolean.FALSE) {
            return Result.buildErrorResult("活动状态变更失败");
        }
        return Result.buildResult(Constants.ResponseCode.SUCCESS.getCode(), "活动撤审");
    }

    @Override
    public Result close(Long activityId, Constants.ActivityState current) {
        Boolean success = activityRepository.alterStatus(activityId, current, Constants.ActivityState.CLOSE);
        if (success == Boolean.FALSE) {
            return Result.buildErrorResult("活动状态变更失败");
        }
        return Result.buildResult(Constants.ResponseCode.SUCCESS.getCode(), "活动审核关闭");
    }

    @Override
    public Result open(Long activityId, Constants.ActivityState current) {
        return Result.buildErrorResult("非关闭活动不能开启");
    }

    @Override
    public Result execute(Long activityId, Constants.ActivityState current) {
        return Result.buildErrorResult("审核活动不能执行");
    }
}
