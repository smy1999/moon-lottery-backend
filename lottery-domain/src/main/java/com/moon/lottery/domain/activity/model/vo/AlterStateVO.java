package com.moon.lottery.domain.activity.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlterStateVO {

    private Long activityId;

    private Integer beforeState;

    private Integer afterState;
}
