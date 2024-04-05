package com.moon.lottery.infrastructure.dao;

import com.moon.lottery.infrastructure.po.Activity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/5
 */

@Mapper
public interface IActivityDao {

    void insertActivity(Activity activity);

    Activity queryActivityByActivityId(Long activityId);

    List<Activity> queryAllActivities();
}
