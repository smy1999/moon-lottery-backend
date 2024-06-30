package com.moon.lottery.domain.activity.model.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/5/25
 */
@Data
public class ActivityBillVO {

    private Long uId;

    private Long activityId;

    private String activityName;

    private LocalDateTime beginDateTime;

    private LocalDateTime endDateTime;

    private Integer stockSurplusCount;

    private Integer state;

    private Long strategyId;

    private Integer takeCount;

    private Integer userTakeLeftCount;
}
