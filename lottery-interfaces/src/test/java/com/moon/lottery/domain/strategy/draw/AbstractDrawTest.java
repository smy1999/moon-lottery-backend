package com.moon.lottery.domain.strategy.draw;

import com.moon.lottery.domain.strategy.model.req.DrawReq;
import com.moon.lottery.domain.strategy.service.draw.AbstractDraw;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/7
 */

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class AbstractDrawTest {

    @Autowired
    private AbstractDraw abstractDraw;


    @Test
    public void testDraw() {

        DrawReq req = new DrawReq(10001L, 1L);
        abstractDraw.drawExec(req);
        abstractDraw.drawExec(req);

        DrawReq req2 = new DrawReq(10002L, 1L);
        abstractDraw.drawExec(req2);
        abstractDraw.drawExec(req2);
    }

}
