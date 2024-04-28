package com.moon.lottery.domain.strategy.repository;

import com.moon.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.moon.lottery.domain.strategy.model.vo.AwardBriefVO;

import java.util.List;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/5
 */
public interface IStrategyRepository {

    StrategyRich queryStrategyRichByStrategyId(Long strategyId);

    AwardBriefVO queryAwardByAwardId(Long awardId);

    /**
     * 查询没有剩余的award_id列表
     */
    List<Long> queryNoSurplusAwardIds(Long strategyId);

    /**
     * 根据影响行数,判断是否扣减成功
     */
    boolean deductAward(Long awardId);
}
