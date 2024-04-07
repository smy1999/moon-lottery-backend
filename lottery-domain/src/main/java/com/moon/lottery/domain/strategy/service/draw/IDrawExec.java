package com.moon.lottery.domain.strategy.service.draw;

import com.moon.lottery.domain.strategy.model.req.DrawReq;
import com.moon.lottery.domain.strategy.model.res.DrawRes;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/6
 */
public interface IDrawExec {

    DrawRes drawExec(DrawReq req);

}
