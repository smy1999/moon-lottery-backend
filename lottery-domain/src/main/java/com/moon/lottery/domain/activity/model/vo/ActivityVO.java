package com.moon.lottery.domain.activity.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ActivityVO {

    private Long activityId;

    private String activityName;

    private String activityDesc;

    private LocalDateTime beginDateTime;

    private LocalDateTime endDateTime;

    private Integer stockCount;

    private Integer takeCount;

    private Integer state;

    private String creator;

}
