package com.moon.lottery.domain.activity.service.stateflow.impl;

import com.moon.lottery.common.Constants;
import com.moon.lottery.common.Result;
import com.moon.lottery.domain.activity.service.stateflow.AbstractState;
import com.moon.lottery.domain.activity.service.stateflow.IStateHandler;
import com.moon.lottery.domain.activity.service.stateflow.StateConfig;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/29
 */
@Service
public class StateHandlerImpl extends StateConfig implements IStateHandler {
    @Override
    public Result arraignment(Long activityId, Constants.ActivityState current) {
        AbstractState state = stateMap.get(current);
        return state.arraignment(activityId, current);
    }

    @Override
    public Result pass(Long activityId, Constants.ActivityState current) {
        AbstractState state = stateMap.get(current);
        return state.pass(activityId, current);
    }

    @Override
    public Result refuse(Long activityId, Constants.ActivityState current) {
        AbstractState state = stateMap.get(current);
        return state.refuse(activityId, current);
    }

    @Override
    public Result revoke(Long activityId, Constants.ActivityState current) {
        AbstractState state = stateMap.get(current);
        return state.revoke(activityId, current);
    }

    @Override
    public Result close(Long activityId, Constants.ActivityState current) {
        AbstractState state = stateMap.get(current);
        return state.close(activityId, current);
    }

    @Override
    public Result open(Long activityId, Constants.ActivityState current) {
        AbstractState state = stateMap.get(current);
        return state.open(activityId, current);
    }

    @Override
    public Result execute(Long activityId, Constants.ActivityState current) {
        AbstractState state = stateMap.get(current);
        return state.execute(activityId, current);
    }
}
