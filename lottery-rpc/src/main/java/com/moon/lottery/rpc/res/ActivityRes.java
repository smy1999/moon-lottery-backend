package com.moon.lottery.rpc.res;

import com.moon.lottery.common.Result;
import com.moon.lottery.rpc.dto.ActivityDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/5
 */
@AllArgsConstructor
@Getter
public class ActivityRes implements Serializable {

    private ActivityDTO activity;

    private Result result;
}
