package com.moon.lottery.domain.activity.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StrategyVO {

    private Long strategyId;

    private String strategyDesc;

    private Integer strategyMode;

    private Integer grantType;

    private LocalDateTime grantDate;

    private String extInfo;

    private List<StrategyDetailVO> strategyDetailList;

}
