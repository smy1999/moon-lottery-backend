package com.moon.lottery.interfaces;

import com.moon.lottery.rpc.IActivityBooth;
import com.moon.lottery.rpc.req.ActivityReq;
import com.moon.lottery.rpc.res.ActivityRes;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/5
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class RpcTest {

    @Autowired
    private IActivityBooth activityBooth;

    private final Logger logger = LoggerFactory.getLogger(RpcTest.class);

    @Test
    public void testActivityBooth() {
        ActivityReq req = new ActivityReq(10001L);
        ActivityRes activityRes = activityBooth.queryActivityByActivityId(req);
        logger.info("{}", JSON.toJSONString(activityRes));
    }
}
