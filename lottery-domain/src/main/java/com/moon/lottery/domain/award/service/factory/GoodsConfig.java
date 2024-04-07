package com.moon.lottery.domain.award.service.factory;

import com.moon.lottery.common.Constants;
import com.moon.lottery.domain.award.service.goods.IDistributionGoods;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/7
 */
public class GoodsConfig {

    @Resource
    private IDistributionGoods couponGoods;

    @Resource
    private IDistributionGoods redeemCodeGoods;

    @Resource
    private IDistributionGoods descGoods;

    @Resource
    private IDistributionGoods physicalGoods;

    protected static ConcurrentHashMap<Integer, IDistributionGoods> goodsMap = new ConcurrentHashMap<>();

    @PostConstruct
    private void init() {
        goodsMap.put(Constants.AwardType.DESC.getCode(), descGoods);
        goodsMap.put(Constants.AwardType.REDEEM_CODE.getCode(), redeemCodeGoods);
        goodsMap.put(Constants.AwardType.COUPON.getCode(), couponGoods);
        goodsMap.put(Constants.AwardType.PHYSICAL.getCode(), physicalGoods);
    }

}
