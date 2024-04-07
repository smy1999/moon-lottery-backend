package com.moon.lottery.domain.strategy.service.draw;

import com.moon.lottery.common.Constants;
import com.moon.lottery.domain.strategy.service.algorithm.IAlgorithm;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/6
 */
public class DrawConfig {

    protected static Map<Integer, IAlgorithm> algorithmMap = new ConcurrentHashMap<>();

    @Resource
    private IAlgorithm fixedProbabilityAlgorithm;

    @Resource
    private IAlgorithm limitedQuantityAlgorithm;

    @PostConstruct
    private void init() {
        // 1 固定概率, 2 固定奖品数量
        algorithmMap.put(Constants.StrategyMode.FIXED.getCode(), fixedProbabilityAlgorithm);
        algorithmMap.put(Constants.StrategyMode.LIMITED.getCode(), limitedQuantityAlgorithm);
    }
}

