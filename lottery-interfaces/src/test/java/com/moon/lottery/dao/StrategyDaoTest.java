package com.moon.lottery.dao;

import com.alibaba.fastjson.JSON;
import com.moon.lottery.infrastructure.dao.IStrategyDao;
import com.moon.lottery.infrastructure.po.Strategy;
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
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class StrategyDaoTest {

    @Autowired
    private IStrategyDao strategyDao;

    @Test
    public void testQuery() {
        Long strategyId = 10001L;
        Strategy strategy = strategyDao.queryStrategyByStrategyId(strategyId);
        log.info("{}", JSON.toJSONString(strategy));

    }

}
