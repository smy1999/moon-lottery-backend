package com.moon.lottery.domain.activity.stateflow;

import com.moon.lottery.BaseTest;
import com.moon.lottery.common.Constants;
import com.moon.lottery.common.Result;
import com.moon.lottery.domain.activity.service.stateflow.event.ArraignmentState;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/28
 */
@Slf4j
public class ArraignmentStateTest extends BaseTest {

    @Resource
    private ArraignmentState arraignmentState;

    @Test
    public void testPass() {
        Result result = arraignmentState.pass(888L, Constants.ActivityState.ARRAIGNMENT);
        log.info("{}", result.getInfo());
    }

}
