package com.moon.lottery.domain.award.goods;

import com.alibaba.fastjson.JSON;
import com.moon.lottery.domain.award.model.req.DistributionReq;
import com.moon.lottery.domain.award.model.res.DistributionRes;
import com.moon.lottery.domain.award.service.goods.DistributionBase;
import com.moon.lottery.domain.award.service.goods.IDistributionGoods;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/7
 */

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class ImplTest {

    @Resource
    private IDistributionGoods couponGoods;

    @Resource
    private IDistributionGoods redeemCodeGoods;

    @Resource
    private IDistributionGoods descGoods;

    @Resource
    private IDistributionGoods physicalGoods;

    private DistributionReq req;

    @Before
    public void initReq() {
        req = new DistributionReq(101L, 1001L, 4L);
    }

    @Test
    public void testCoupon() {
        DistributionRes res = couponGoods.distribute(req);
        log.info("Coupon: {}, {}", couponGoods.getDistributionGoodsType(), JSON.toJSONString(res));
    }
    @Test
    public void testRedeemCode() {
        DistributionRes res = redeemCodeGoods.distribute(req);
        log.info("Coupon: {}, {}", redeemCodeGoods.getDistributionGoodsType(), JSON.toJSONString(res));
    }

    @Test
    public void testPhysical() {
        DistributionRes res = physicalGoods.distribute(req);
        log.info("Coupon: {}, {}", physicalGoods.getDistributionGoodsType(), JSON.toJSONString(res));
    }

    @Test
    public void testDesc() {
        DistributionRes res = descGoods.distribute(req);
        log.info("Coupon: {}, {}", descGoods.getDistributionGoodsType(), JSON.toJSONString(res));
    }



}
