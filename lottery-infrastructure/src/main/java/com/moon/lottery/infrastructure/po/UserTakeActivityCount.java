package com.moon.lottery.infrastructure.po;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/6/16
 */
@Data
public class UserTakeActivityCount {

    private Long id;
    private Long uId;
    private Long activityId;
    private Integer totalCount;
    private Integer leftCount;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
