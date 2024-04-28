package com.moon.lottery.domain.strategy.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StrategyBriefVO {

    private Long strategyId;

    private String strategyDesc;

    private Integer strategyMode;

    private Integer grantType;

    private LocalDateTime grantDate;

    private String extInfo;
}
