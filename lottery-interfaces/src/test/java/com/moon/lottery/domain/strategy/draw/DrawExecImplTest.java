package com.moon.lottery.domain.strategy.draw;

import com.moon.lottery.domain.strategy.model.req.DrawReq;
import com.moon.lottery.domain.strategy.service.draw.AbstractDraw;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.annotation.Resource;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/7
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DrawExecImplTest {

    @Resource
    private AbstractDraw draw;

    @Test
    public void testDrawExec() {
        DrawReq drawReq = new DrawReq(10001L, 1L);
        for (int i = 0; i < 10; i++) {
            draw.drawExec(drawReq);
        }
        DrawReq drawReq2 = new DrawReq(10002L, 1L);
        for (int i = 0; i < 10; i++) {
            draw.drawExec(drawReq2);
        }
    }

}
