package com.moon.lottery.infrastructure.po;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/5
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StrategyDetail {

    private Long id;

    private Long strategyId;

    private Long awardId;

    private String awardName;

    private Integer awardCount;

    private Integer awardSurplusCount;

    private BigDecimal awardRate;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
