package com.moon.lottery.dao;

import com.alibaba.fastjson.JSON;
import com.moon.lottery.infrastructure.dao.IStrategyDetailDao;
import com.moon.lottery.infrastructure.po.StrategyDetail;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/5
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class StrategyDetailDaoTest {

    @Autowired
    private IStrategyDetailDao strategyDetailDao;

    @Test
    public void testQuery() {
        Long strategyId = 10001L;
        List<StrategyDetail> details = strategyDetailDao.queryStrategyDetailsByStrategyId(strategyId);
        for (StrategyDetail detail : details) {
            log.info("{}", JSON.toJSONString(detail));
        }

    }

}
