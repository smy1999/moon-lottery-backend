package com.moon.lottery.domain.activity.model.req;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/5/25
 */
@Data
public class PartakeReq {

    private Long uId;

    private Long activityId;

    private LocalDateTime partakeDate;
}
