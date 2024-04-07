package com.moon.lottery.domain.award.service.goods;

import com.moon.lottery.domain.award.model.req.DistributionReq;
import com.moon.lottery.domain.award.model.res.DistributionRes;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/7
 */
public interface IDistributionGoods {

    DistributionRes distribute(DistributionReq req);

    Integer getDistributionGoodsType();
}
