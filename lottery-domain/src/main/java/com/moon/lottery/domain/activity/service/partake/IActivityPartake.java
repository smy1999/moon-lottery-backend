package com.moon.lottery.domain.activity.service.partake;

import com.moon.lottery.domain.activity.model.req.PartakeReq;
import com.moon.lottery.domain.activity.model.res.PartakeResult;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/5/25
 */
public interface IActivityPartake {

    PartakeResult doPartake(PartakeReq req);
}
