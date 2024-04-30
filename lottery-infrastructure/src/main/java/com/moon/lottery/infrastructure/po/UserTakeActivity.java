package com.moon.lottery.infrastructure.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserTakeActivity {

    private Long id;
    private String uId;
    private Long takeId;
    private Long activityId;
    private String activityName;
    private LocalDateTime takeDate;
    private Integer takeCount;
    private String uuid;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
