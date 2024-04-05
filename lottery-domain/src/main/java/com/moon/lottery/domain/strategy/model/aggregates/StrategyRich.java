package com.moon.lottery.domain.strategy.model.aggregates;


import com.moon.lottery.infrastructure.po.StrategyDetail;
import com.moon.lottery.infrastructure.po.Strategy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/5
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StrategyRich {

    private Long StrategyId;

    private Strategy strategy;

    private List<StrategyDetail> strategyDetailList;
}
