package com.moon.lottery.infrastructure.po;

import lombok.*;

import java.time.LocalDateTime;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/5
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Activity {

    private Long id;

    private Long activityId;

    private String activityName;

    private String activityDesc;

    private LocalDateTime beginDateTime;

    private LocalDateTime endDateTime;

    private Integer stockCount;

    private Integer stockSurplusCount;

    private Integer takeCount;

    private Long strategyId;

    private Integer state;

    private String creator;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
