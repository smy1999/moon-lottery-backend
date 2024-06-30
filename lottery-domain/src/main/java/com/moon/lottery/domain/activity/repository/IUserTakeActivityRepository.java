package com.moon.lottery.domain.activity.repository;

import java.time.LocalDateTime;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/6/30
 */
public interface IUserTakeActivityRepository {


    void takeActivity(Long uId, Long takeId, Long activityId, String activityName, LocalDateTime partakeDate, Integer takeCount, Integer userTakeLeftCount);
}
