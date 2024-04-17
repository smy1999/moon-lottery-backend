package com.moon.lottery.domain.activity.service.deploy;

import com.moon.lottery.domain.activity.model.req.ActivityConfigReq;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/16
 */
public interface IActivityDeploy {

    void createActivity(ActivityConfigReq activityConfigReq);

    void updateActivity(ActivityConfigReq activityConfigReq);


}
