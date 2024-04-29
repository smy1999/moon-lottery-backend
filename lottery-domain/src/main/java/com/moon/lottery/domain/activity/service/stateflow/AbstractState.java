package com.moon.lottery.domain.activity.service.stateflow;

import com.moon.lottery.common.Constants;
import com.moon.lottery.common.Result;
import com.moon.lottery.domain.activity.repository.IActivityRepository;

import javax.annotation.Resource;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/18
 */
public abstract class AbstractState {

    @Resource
    protected IActivityRepository activityRepository;

    /**
     * 活动提审
     */
    public abstract Result arraignment(Long activityId, Constants.ActivityState current);

    /**
     * 审核通过
     */
    public abstract Result pass(Long activityId, Constants.ActivityState current);

    /**
     * 审核拒绝
     */
    public abstract Result refuse(Long activityId, Constants.ActivityState current);

    /**
     * 撤销审核
     */
    public abstract Result revoke(Long activityId, Constants.ActivityState current);

    /**
     * 关闭活动
     */
    public abstract Result close(Long activityId, Constants.ActivityState current);

    /**
     * 开启活动
     */
    public abstract Result open(Long activityId, Constants.ActivityState current);

    /**
     * 执行活动
     */
    public abstract Result execute(Long activityId, Constants.ActivityState current);

}
