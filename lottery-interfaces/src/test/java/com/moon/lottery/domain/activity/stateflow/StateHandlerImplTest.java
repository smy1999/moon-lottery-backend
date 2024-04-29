package com.moon.lottery.domain.activity.stateflow;

import com.alibaba.fastjson.JSON;
import com.moon.lottery.BaseTest;
import com.moon.lottery.common.Constants;
import com.moon.lottery.common.Result;
import com.moon.lottery.domain.activity.service.stateflow.impl.StateHandlerImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/29
 */
@Slf4j
public class StateHandlerImplTest extends BaseTest {

    @Resource
    private StateHandlerImpl stateHandler;

    @Test
    public void testStateFlow() {
        Long activityId = 888L;
        Result result = stateHandler.open(activityId, Constants.ActivityState.EXECUTE);
        System.out.println(result.getInfo());
    }

    @Test
    public void test_alterState() {
        log.info("提交审核，测试：{}", JSON.toJSONString(stateHandler.arraignment(100001L, Constants.ActivityState.EDIT)));
        log.info("审核通过，测试：{}", JSON.toJSONString(stateHandler.pass(100001L, Constants.ActivityState.ARRAIGNMENT)));
        log.info("运行活动，测试：{}", JSON.toJSONString(stateHandler.execute(100001L, Constants.ActivityState.PASS)));
        log.info("二次提审，测试：{}", JSON.toJSONString(stateHandler.pass(100001L, Constants.ActivityState.EDIT)));
    }

}
