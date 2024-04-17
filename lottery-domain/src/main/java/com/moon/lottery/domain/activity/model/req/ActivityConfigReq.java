package com.moon.lottery.domain.activity.model.req;

import com.moon.lottery.domain.activity.model.aggregates.ActivityConfigRich;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ActivityConfigReq {

    private Long activityId;

    private ActivityConfigRich activityConfigRich;

}
