package com.moon.lottery.domain.activity.partake;

import com.moon.lottery.domain.activity.model.req.PartakeReq;
import com.moon.lottery.domain.activity.model.res.PartakeResult;
import com.moon.lottery.domain.activity.service.partake.IActivityPartake;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/6/30
 */

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class ActivityPartakeTest {

    @Resource
    private IActivityPartake activityPartake;

    @Test
    public void testDoPartake() {
        PartakeReq req = new PartakeReq();
        req.setUId(1L);
        req.setActivityId(100001L);
        req.setPartakeDate(LocalDateTime.now());
        PartakeResult result = activityPartake.doPartake(req);
        log.info("code: {}, info: {}, result: {}", result.getCode(), result.getInfo(), result);
    }

    @Test
    public void testDoPartakeMultiTimes() {
        PartakeReq req = new PartakeReq();
        req.setUId(1L);
        req.setActivityId(100001L);
        req.setPartakeDate(LocalDateTime.now());
        for (int i = 0; i < 5; i++) {
            PartakeResult result = activityPartake.doPartake(req);
            log.info("code: {}, info: {}, result: {}", result.getCode(), result.getInfo(), result);
        }
    }
}
