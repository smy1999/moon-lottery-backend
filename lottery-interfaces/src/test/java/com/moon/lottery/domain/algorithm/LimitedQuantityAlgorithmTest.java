package com.moon.lottery.domain.algorithm;

import com.alibaba.fastjson.JSON;
import com.moon.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.moon.lottery.domain.strategy.model.vo.AwardRateInfo;
import com.moon.lottery.domain.strategy.repository.IStrategyRepository;
import com.moon.lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import com.moon.lottery.domain.strategy.service.algorithm.impl.LimitedQuantityAlgorithm;
import com.moon.lottery.infrastructure.po.StrategyDetail;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/6
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class LimitedQuantityAlgorithmTest {


    @Resource(type = LimitedQuantityAlgorithm.class)
    private BaseAlgorithm algo;

    @Resource
    private IStrategyRepository strategyRepository;

    @Test
    public void testRandom() {
        long strategyId = 10001L;
        StrategyRich strategyRich = strategyRepository.queryStrategyRichByStrategyId(strategyId);
        List<StrategyDetail> details = strategyRich.getStrategyDetailList();

        List<AwardRateInfo> awardRateInfoList = new ArrayList<>();
        details.forEach(detail -> {
            AwardRateInfo awardRateInfo = new AwardRateInfo();
            BeanUtils.copyProperties(detail, awardRateInfo);
            awardRateInfoList.add(awardRateInfo);
        });

        algo.initBucket(strategyId, awardRateInfoList);

        List<Long> exclude = new ArrayList<>();
        log.info("{}", JSON.toJSONString(exclude));
        for (int i = 0; i < 10; i++) {
            log.info("{}", algo.randomDraw(strategyId, exclude));
        }
        exclude.add(1L);
        log.info("{}", JSON.toJSONString(exclude));
        for (int i = 0; i < 10; i++) {
            log.info("{}", algo.randomDraw(strategyId, exclude));
        }
        exclude.add(2L);
        exclude.add(3L);
        log.info("{}", JSON.toJSONString(exclude));
        for (int i = 0; i < 10; i++) {
            log.info("{}", algo.randomDraw(strategyId, exclude));
        }
        exclude.add(4L);
        log.info("{}", JSON.toJSONString(exclude));
        for (int i = 0; i < 10; i++) {
            log.info("{}", algo.randomDraw(strategyId, exclude));
        }
        exclude.add(5L);
        log.info("{}", JSON.toJSONString(exclude));
        for (int i = 0; i < 10; i++) {
            log.info("{}", algo.randomDraw(strategyId, exclude));
        }
    }


}
