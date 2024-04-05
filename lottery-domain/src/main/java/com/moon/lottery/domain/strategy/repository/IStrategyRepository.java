package com.moon.lottery.domain.strategy.repository;

import com.moon.lottery.domain.strategy.model.aggregates.StrategyRich;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/5
 */
public interface IStrategyRepository {

    StrategyRich queryStrategyRichByStrategyId(Long strategyId);

}
