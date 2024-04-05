package com.moon.lottery.infrastructure.dao;

import com.moon.lottery.infrastructure.po.Strategy;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/5
 */
@Mapper
public interface IStrategyDao {

    Strategy queryStrategyByStrategyId(Long strategyId);
}
