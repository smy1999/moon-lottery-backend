package com.moon.lottery.domain.activity.service.stateflow;

import com.moon.lottery.common.Constants;
import com.moon.lottery.domain.activity.service.stateflow.event.*;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/29
 */
public class StateConfig {

    @Resource
    private EditState editState;
    @Resource
    private ArraignmentState arraignmentState;
    @Resource
    private RefuseState refuseState;
    @Resource
    private PassState passState;
    @Resource
    private OpenState openState;
    @Resource
    private CloseState closeState;
    @Resource
    private ExecuteState executeState;

    protected Map<Constants.ActivityState, AbstractState> stateMap;

    @PostConstruct
    private void init() {
        stateMap = new ConcurrentHashMap<>();
        stateMap.put(Constants.ActivityState.EDIT, editState);
        stateMap.put(Constants.ActivityState.ARRAIGNMENT, arraignmentState);
        stateMap.put(Constants.ActivityState.PASS, passState);
        stateMap.put(Constants.ActivityState.REFUSE, refuseState);
        stateMap.put(Constants.ActivityState.OPEN, openState);
        stateMap.put(Constants.ActivityState.CLOSE, closeState);
        stateMap.put(Constants.ActivityState.EXECUTE, executeState);
    }

}
