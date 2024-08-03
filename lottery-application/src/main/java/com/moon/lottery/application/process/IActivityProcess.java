package com.moon.lottery.application.process;

import com.moon.lottery.application.process.req.DrawProcessReq;
import com.moon.lottery.application.process.res.DrawProcessResult;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/7/1
 */
public interface IActivityProcess {

    DrawProcessResult doDrawProcess(DrawProcessReq req);

}
