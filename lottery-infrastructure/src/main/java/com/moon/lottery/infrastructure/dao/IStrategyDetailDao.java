package com.moon.lottery.infrastructure.dao;

import com.moon.lottery.infrastructure.po.StrategyDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/5
 */

@Mapper
public interface IStrategyDetailDao {

    List<StrategyDetail> queryStrategyDetailsByStrategyId(Long strategyId);

    /**
     * 查询没有剩余的award_id列表
     * @param strategyId
     * @return
     */
    List<Long> queryNoSurplusAwardIds(Long strategyId);

    /**
     * 扣减数量
     * @param awardId
     * @return
     */
    int deductAward(Long awardId);

    void insertStrategyDetailList(List<StrategyDetail> strategyDetailList);
}
