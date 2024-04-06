package com.moon.lottery.domain.strategy.service.algorithm;

import com.moon.lottery.domain.strategy.model.vo.AwardRateInfo;

import java.util.List;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/5
 */
public interface IAlgorithm {


    /**
     * Draw once.
     * @param strategyId
     * @param excludeAwardIds
     * @return Draw result.
     */
    Long randomDraw(Long strategyId, List<Long> excludeAwardIds);


    void initBucket(Long StrategyId, List<AwardRateInfo> awardRateInfoList);

    boolean existsBucket(Long strategyId);

}
