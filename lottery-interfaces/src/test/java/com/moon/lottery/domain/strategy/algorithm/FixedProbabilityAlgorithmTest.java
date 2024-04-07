package com.moon.lottery.domain.strategy.algorithm;

import com.moon.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.moon.lottery.domain.strategy.model.vo.AwardRateInfo;
import com.moon.lottery.domain.strategy.repository.IStrategyRepository;
import com.moon.lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import com.moon.lottery.domain.strategy.service.algorithm.impl.FixedProbabilityAlgorithm;
import com.moon.lottery.infrastructure.po.StrategyDetail;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
public class FixedProbabilityAlgorithmTest {

    @Resource(type= FixedProbabilityAlgorithm.class)
    private BaseAlgorithm algorithm;

    @Autowired
    private IStrategyRepository strategyRepository;

    @Test
    public void testRandomDraw() {
        long strategyId = 10001L;
        StrategyRich strategyRich = strategyRepository.queryStrategyRichByStrategyId(strategyId);
        List<StrategyDetail> details = strategyRich.getStrategyDetailList();

        List<AwardRateInfo> awardRateInfoList = new ArrayList<>();
        details.forEach(detail -> {
            AwardRateInfo awardRateInfo = new AwardRateInfo();
            BeanUtils.copyProperties(detail, awardRateInfo);
            awardRateInfoList.add(awardRateInfo);
        });

        algorithm.initBucket(strategyId, awardRateInfoList);
        for (int i = 0; i < 5; i++) {
            log.info("{}", algorithm.randomDraw(strategyId, new ArrayList<>()));
        }
    }
}
