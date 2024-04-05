package com.moon.lottery.interfaces;

import com.moon.lottery.common.Result;
import com.moon.lottery.rpc.IActivityBooth;
import com.moon.lottery.rpc.dto.ActivityDTO;
import com.moon.lottery.rpc.req.ActivityReq;
import com.moon.lottery.rpc.res.ActivityRes;
import com.moon.lottery.infrastructure.dao.IActivityDao;
import com.moon.lottery.infrastructure.po.Activity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/5
 */
@Component
public class ActivityBooth implements IActivityBooth {

    @Resource
    private IActivityDao activityDao;

    @Override
    public ActivityRes queryActivityByActivityId(ActivityReq req) {

        Long activityId = req.getActivityId();
        Activity activity = activityDao.queryActivityByActivityId(activityId);
        ActivityDTO activityDto = new ActivityDTO();
        BeanUtils.copyProperties(activity, activityDto);
        return new ActivityRes(activityDto, Result.buildSuccessResult());
    }
}
