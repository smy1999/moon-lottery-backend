package com.moon.lottery.domain.strategy.repository.impl;

import com.moon.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.moon.lottery.domain.strategy.repository.IStrategyRepository;
import com.moon.lottery.infrastructure.dao.IStrategyDao;
import com.moon.lottery.infrastructure.dao.IStrategyDetailDao;
import com.moon.lottery.infrastructure.po.Strategy;
import com.moon.lottery.infrastructure.po.StrategyDetail;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/5
 */
@Repository
public class StrategyRepository implements IStrategyRepository {

    @Resource
    private IStrategyDao strategyDao;

    @Resource
    private IStrategyDetailDao strategyDetailDao;

    @Override
    public StrategyRich queryStrategyRichByStrategyId(Long strategyId) {
        Strategy strategy = strategyDao.queryStrategyByStrategyId(strategyId);
        List<StrategyDetail> strategyDetails = strategyDetailDao.queryStrategyDetailsByStrategyId(strategyId);
        return new StrategyRich(strategyId, strategy, strategyDetails);
    }
}
