package com.moon.lottery.application.process.impl;

import com.moon.lottery.application.process.IActivityProcess;
import com.moon.lottery.application.process.req.DrawProcessReq;
import com.moon.lottery.application.process.res.DrawProcessResult;
import com.moon.lottery.domain.activity.model.req.PartakeReq;
import com.moon.lottery.domain.activity.model.res.PartakeResult;
import com.moon.lottery.domain.activity.service.partake.BaseActivityPartake;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/7/1
 */
@Service
public class ActivityProcessImpl implements IActivityProcess {

    @Resource
    private BaseActivityPartake baseActivityPartake;

    @Override
    public DrawProcessResult doDrawProcess(DrawProcessReq req) {

        PartakeReq partakeReq = new PartakeReq();
        partakeReq.setUId(req.getUId());
        partakeReq.setActivityId(req.getActivityId());
        partakeReq.setPartakeDate(LocalDateTime.now());

        PartakeResult partakeResult = baseActivityPartake.doPartake(partakeReq);


        return null;
    }
}
