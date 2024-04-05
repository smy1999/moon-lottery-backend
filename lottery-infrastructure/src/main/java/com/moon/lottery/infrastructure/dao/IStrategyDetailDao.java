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
}
