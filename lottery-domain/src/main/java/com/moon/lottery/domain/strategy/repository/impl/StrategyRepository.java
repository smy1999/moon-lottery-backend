package com.moon.lottery.domain.strategy.repository.impl;

import com.moon.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.moon.lottery.domain.strategy.repository.IStrategyRepository;
import com.moon.lottery.infrastructure.dao.IAwardDao;
import com.moon.lottery.infrastructure.dao.IStrategyDao;
import com.moon.lottery.infrastructure.dao.IStrategyDetailDao;
import com.moon.lottery.infrastructure.po.Award;
import com.moon.lottery.infrastructure.po.Strategy;
import com.moon.lottery.infrastructure.po.StrategyDetail;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/5
 */
//@Repository
@Component
public class StrategyRepository implements IStrategyRepository {

    @Resource
    private IStrategyDao strategyDao;

    @Resource
    private IStrategyDetailDao strategyDetailDao;

    @Resource
    private IAwardDao awardDao;

    @Override
    public StrategyRich queryStrategyRichByStrategyId(Long strategyId) {
        Strategy strategy = strategyDao.queryStrategyByStrategyId(strategyId);
        List<StrategyDetail> strategyDetails = strategyDetailDao.queryStrategyDetailsByStrategyId(strategyId);
        return new StrategyRich(strategyId, strategy, strategyDetails);
    }

    @Override
    public Award queryAwardByAwardId(Long awardId) {
        return awardDao.queryAwardByAwardId(awardId);
    }

    /**
     * 查询没有剩余的award_id列表
     * @param strategyId
     * @return
     */
    @Override
    public List<Long> queryNoSurplusAwardIds(Long strategyId) {
        return strategyDetailDao.queryNoSurplusAwardIds(strategyId);
    }

    /**
     * 根据影响行数,判断是否扣减成功
     * @param awardId
     * @return
     */
    @Override
    public boolean deductAward(Long awardId) {
        return strategyDetailDao.deductAward(awardId) > 0;
    }
}
