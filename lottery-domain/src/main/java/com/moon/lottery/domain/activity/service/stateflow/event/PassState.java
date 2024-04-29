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
public class PassState extends AbstractState {
    @Override
    public Result arraignment(Long activityId, Constants.ActivityState current) {
        return Result.buildErrorResult("通过审核活动不能提审");
    }

    @Override
    public Result pass(Long activityId, Constants.ActivityState current) {
        return Result.buildErrorResult("通过审核活动不能重复通过审核");
    }

    @Override
    public Result refuse(Long activityId, Constants.ActivityState current) {
        Boolean success = activityRepository.alterStatus(activityId, current, Constants.ActivityState.REFUSE);
        if (success == Boolean.FALSE) {
            return Result.buildErrorResult("活动状态变更失败");
        }
        return Result.buildResult(Constants.ResponseCode.SUCCESS.getCode(), "通过活动拒绝成功");
    }

    @Override
    public Result revoke(Long activityId, Constants.ActivityState current) {
        return Result.buildErrorResult("通过审核活动不能撤回");
    }

    @Override
    public Result close(Long activityId, Constants.ActivityState current) {
        Boolean success = activityRepository.alterStatus(activityId, current, Constants.ActivityState.CLOSE);
        if (success == Boolean.FALSE) {
            return Result.buildErrorResult("活动状态变更失败");
        }
        return Result.buildResult(Constants.ResponseCode.SUCCESS.getCode(), "通过活动关闭成功");
    }

    @Override
    public Result open(Long activityId, Constants.ActivityState current) {
        return Result.buildErrorResult("通过审核活动不能重复开始");
    }

    @Override
    public Result execute(Long activityId, Constants.ActivityState current) {
        Boolean success = activityRepository.alterStatus(activityId, current, Constants.ActivityState.EXECUTE);
        if (success == Boolean.FALSE) {
            return Result.buildErrorResult("活动状态变更失败");
        }
        return Result.buildResult(Constants.ResponseCode.SUCCESS.getCode(), "通过活动开始执行");
    }
}
