package com.moon.lottery.rpc;

import com.moon.lottery.rpc.req.ActivityReq;
import com.moon.lottery.rpc.res.ActivityRes;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/5
 */
public interface IActivityBooth {

    ActivityRes queryActivityByActivityId(ActivityReq req);
}
