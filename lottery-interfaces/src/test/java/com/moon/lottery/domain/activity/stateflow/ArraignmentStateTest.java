package com.moon.lottery.domain.activity.stateflow;

import com.moon.lottery.BaseTest;
import com.moon.lottery.common.Constants;
import com.moon.lottery.domain.activity.service.stateflow.ArraignmentState;

import javax.annotation.Resource;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/28
 */
public class ArraignmentStateTest extends BaseTest {

    @Resource
    private ArraignmentState arraignmentState;

    public void testPass() {
        arraignmentState.pass(888L, Constants.ActivityState.PASS);
    }

}
