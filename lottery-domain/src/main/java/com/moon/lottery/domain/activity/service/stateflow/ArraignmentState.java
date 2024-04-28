package com.moon.lottery.domain.activity.service.stateflow;

import com.moon.lottery.common.Constants;
import com.moon.lottery.common.Result;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/19
 */
@Component
public class ArraignmentState extends AbstractState {
    @Override
    public Result arraignment(Long activityId, Enum<Constants.ActivityState> current) {
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
    public Result refuse(Long activityId, Enum<Constants.ActivityState> current) {
        return null;
    }

    @Override
    public Result revoke(Long activityId, Enum<Constants.ActivityState> current) {
        return null;
    }

    @Override
    public Result close(Long activityId, Enum<Constants.ActivityState> current) {
        return null;
    }

    @Override
    public Result open(Long activityId, Enum<Constants.ActivityState> current) {
        return null;
    }

    @Override
    public Result execute(Long activityId, Enum<Constants.ActivityState> current) {
        return null;
    }
}
