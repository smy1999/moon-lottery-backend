package com.moon.lottery.domain.award.service.goods.impl;

import com.moon.lottery.common.Constants;
import com.moon.lottery.domain.award.model.req.DistributionReq;
import com.moon.lottery.domain.award.model.res.DistributionRes;
import com.moon.lottery.domain.award.service.goods.DistributionBase;
import com.moon.lottery.domain.award.service.goods.IDistributionGoods;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/7
 */
@Slf4j
@Service
public class RedeemCodeGoods extends DistributionBase implements IDistributionGoods {
    @Override
    public DistributionRes distribute(DistributionReq req) {
        Long uId = req.getUId();

        log.info("发送兑换码, uId: {}, awardContent: {}", uId, req.getAwardContent());

        super.updateUserAwardState(uId, req.getOrderId(), Constants.AwardState.SUCCESS.getCode(), Constants.AwardState.SUCCESS.getInfo());

        return new DistributionRes(uId, Constants.AwardState.SUCCESS.getCode(), Constants.AwardState.SUCCESS.getInfo());

    }

    @Override
    public Integer getDistributionGoodsType() {
        return Constants.AwardType.REDEEM_CODE.getCode();
    }
}
