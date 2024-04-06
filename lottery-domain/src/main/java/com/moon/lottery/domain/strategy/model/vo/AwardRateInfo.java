package com.moon.lottery.domain.strategy.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/6
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AwardRateInfo {

    private Long awardId;

    private BigDecimal awardRate;
}
