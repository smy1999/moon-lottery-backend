package com.moon.lottery.domain.strategy.algorithm;

import com.moon.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.moon.lottery.domain.strategy.model.vo.AwardRateInfo;
import com.moon.lottery.domain.strategy.repository.IStrategyRepository;
import com.moon.lottery.domain.strategy.service.algorithm.impl.FixedProbabilityAlgorithm;
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
 * @date: 2024/4/5
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class BaseAlgorithmTest {

    @Resource
    private IStrategyRepository strategyRepository;

    @Test
    public void testInjection() {
        StrategyRich strategyRich = strategyRepository.queryStrategyRichByStrategyId(10001L);
        log.info("{}", strategyRich);
    }

    @Test
    public void testInitBucket() {

        Long strategyId = 10001L;
        StrategyRich strategyRich = strategyRepository.queryStrategyRichByStrategyId(strategyId);
        List<StrategyDetail> details = strategyRich.getStrategyDetailList();

        List<AwardRateInfo> awardRateInfoList = new ArrayList<>();
        details.forEach(detail -> {
            AwardRateInfo awardRateInfo = new AwardRateInfo();
            BeanUtils.copyProperties(detail, awardRateInfo);
            awardRateInfoList.add(awardRateInfo);
        });

        FixedProbabilityAlgorithm algorithm = new FixedProbabilityAlgorithm();
        algorithm.initBucket(strategyId, awardRateInfoList);
    }

    @Test
    public void testExist() {
        FixedProbabilityAlgorithm algorithm = new FixedProbabilityAlgorithm();

        Long strategyId = 10001L;
        boolean b1 = algorithm.existsBucket(strategyId);

        StrategyRich strategyRich = strategyRepository.queryStrategyRichByStrategyId(strategyId);
        List<StrategyDetail> details = strategyRich.getStrategyDetailList();

        List<AwardRateInfo> awardRateInfoList = new ArrayList<>();
        details.forEach(detail -> {
            AwardRateInfo awardRateInfo = new AwardRateInfo();
            BeanUtils.copyProperties(detail, awardRateInfo);
            awardRateInfoList.add(awardRateInfo);
        });

        algorithm.initBucket(strategyId, awardRateInfoList);

        boolean b2 = algorithm.existsBucket(strategyId);


        Long notExistId = 10002L;
        boolean b3 = algorithm.existsBucket(notExistId);

        log.info("False, {}", b1);
        log.info("True, {}", b2);
        log.info("False, {}", b3);

    }


}
