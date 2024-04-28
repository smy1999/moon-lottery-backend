package com.moon.lottery.domain.strategy.model.aggregates;


import com.moon.lottery.domain.strategy.model.vo.StrategyBriefVO;
import com.moon.lottery.domain.strategy.model.vo.StrategyDetailBriefVO;
import lombok.*;

import java.util.List;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/5
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StrategyRich {

    private Long StrategyId;

    private StrategyBriefVO strategy;

    private List<StrategyDetailBriefVO> strategyDetailList;
}
