package com.moon.lottery.domain.strategy.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StrategyDetailBriefVO {

    private Long strategyId;

    private Long awardId;

    private String awardName;

    private Integer awardCount;

    private Integer awardSurplusCount;

    private BigDecimal awardRate;
}
