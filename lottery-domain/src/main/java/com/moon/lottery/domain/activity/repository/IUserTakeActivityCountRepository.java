package com.moon.lottery.domain.activity.repository;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/6/30
 */
public interface IUserTakeActivityCountRepository {

    /**
     * 扣减个人活动参与次数
     *
     * @param uId
     * @param activityId
     * @param takeCount
     * @param userTakeLeftCount
     * @return
     */
    int subtractLeftCount(Long uId, Long activityId, Integer takeCount, Integer userTakeLeftCount);
}

