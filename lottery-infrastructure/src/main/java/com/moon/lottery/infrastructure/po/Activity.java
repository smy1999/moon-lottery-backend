package com.moon.lottery.infrastructure.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/5
 */
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Activity {

    private Long id;

    private Long activityId;

    private String activityName;

    private String activityDesc;

    private LocalDateTime beginDateTime;

    private LocalDateTime endDateTime;

    private Integer stockCount;

    private Integer takeCount;

    private Integer state;

    private String creator;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
