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
     *
     * @param activityId
     * @param current
     * @return
     */
    public abstract Result arraignment(Long activityId, Enum<Constants.ActivityState> current);

    /**
     * 审核通过
     *
     * @param activityId
     * @param current
     * @return
     */
    public abstract Result pass(Long activityId, Constants.ActivityState current);

    /**
     * 审核拒绝
     *
     * @param activityId
     * @param current
     * @return
     */
    public abstract Result refuse(Long activityId, Enum<Constants.ActivityState> current);

    /**
     * 撤销审核
     *
     * @param activityId
     * @param current
     * @return
     */
    public abstract Result revoke(Long activityId, Enum<Constants.ActivityState> current);

    /**
     * 关闭活动
     *
     * @param activityId
     * @param current
     * @return
     */
    public abstract Result close(Long activityId, Enum<Constants.ActivityState> current);

    /**
     * 开启活动
     *
     * @param activityId
     * @param current
     * @return
     */
    public abstract Result open(Long activityId, Enum<Constants.ActivityState> current);

    /**
     * 执行活动
     *
     * @param activityId
     * @param current
     * @return
     */
    public abstract Result execute(Long activityId, Enum<Constants.ActivityState> current);



}