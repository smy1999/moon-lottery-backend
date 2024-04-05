package com.moon.lottery.rpc.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/5
 */

@Getter
@Setter
@AllArgsConstructor
public class ActivityReq implements Serializable {

    private Long activityId;

}
