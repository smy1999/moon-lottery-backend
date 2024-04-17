package com.moon.lottery.domain.activity.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/17
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StrategyDetailVO {

    private Long strategyId;

    private Long awardId;

    private String awardName;

    private Integer awardCount;

    private Integer awardSurplusCount;

    private BigDecimal awardRate;
}
