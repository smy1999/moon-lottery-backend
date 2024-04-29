package com.moon.lottery.domain.activity.service.stateflow;

import com.moon.lottery.common.Constants;
import com.moon.lottery.common.Result;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/29
 */
public interface IStateHandler {

    Result arraignment(Long activityId, Constants.ActivityState current);

    /**
     * 审核通过
     */
    Result pass(Long activityId, Constants.ActivityState current);

    /**
     * 审核拒绝
     */
    Result refuse(Long activityId, Constants.ActivityState current);

    /**
     * 撤销审核
     */
    Result revoke(Long activityId, Constants.ActivityState current);

    /**
     * 关闭活动
     */
    Result close(Long activityId, Constants.ActivityState current);

    /**
     * 开启活动
     */
    Result open(Long activityId, Constants.ActivityState current);

    /**
     * 执行活动
     */
    Result execute(Long activityId, Constants.ActivityState current);
}
