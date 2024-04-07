package com.moon.lottery.domain.strategy.draw;

import com.moon.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.moon.lottery.domain.strategy.service.draw.DrawSupport;
import com.moon.lottery.infrastructure.po.Award;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.annotation.Resource;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/6
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class DrawStrategySupportTest {

    @Resource(name = "drawSupport")
    private DrawSupport support;

    @Test
    public void testQueryStrategyRich() {
        Long strategyId = 10001L;
//        StrategyRich strategyRich = support.queryStrategyRichByStrategyId(strategyId);
//        log.info("{}", JSON.toJSONString(strategyRich));
    }

    @Test
    public void testQueryAward() {
        String awardId = "1";
//        Award award = support.queryAwardByAwardId(awardId);
//        log.info("{}", JSON.toJSONString(award));
    }
}
