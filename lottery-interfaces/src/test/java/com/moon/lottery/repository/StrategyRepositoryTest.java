package com.moon.lottery.repository;

import com.alibaba.fastjson.JSON;
import com.moon.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.moon.lottery.domain.strategy.repository.IStrategyRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/5
 */

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class StrategyRepositoryTest {

    @Autowired
    private IStrategyRepository strategyRepository;


    @Test
    public void queryStrategyRichByStrategyIdTest() {
        Long strategyId = 10001L;
        StrategyRich strategyRich = strategyRepository.queryStrategyRichByStrategyId(strategyId);
        log.info("{}", JSON.toJSONString(strategyRich));
    }

}
