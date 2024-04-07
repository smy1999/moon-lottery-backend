package com.moon.lottery.domain.award.factory;

import com.moon.lottery.domain.award.service.factory.DistributionGoodsFactory;
import com.moon.lottery.domain.award.service.factory.GoodsConfig;
import com.moon.lottery.domain.award.service.goods.IDistributionGoods;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/7
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class FactoryTest {

//    @Autowired
//    private GoodsConfig goodsConfig;
//
//    @Test
//    public void testMap() {
//        for (int i = 1; i <= 4; i++) {
//            IDistributionGoods goods = goodsConfig.goodsMap.get(i);
//            String name = goods.getClass().getSimpleName();
//            log.info("{}: {}", i, name);
//        }
//    }

    @Autowired
    private DistributionGoodsFactory distributionGoodsFactory;

    @Test
    public void testFactory() {
        for (int i = 1; i <= 4; i++) {

            IDistributionGoods goods = distributionGoodsFactory.getDistributionGoodsService(i);
            String name = goods.getClass().getSimpleName();
            log.info("{}: {}", i, name);
        }
    }

}
