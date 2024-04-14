package com.moon.lottery.domain.award;

import com.alibaba.fastjson.JSON;
import com.moon.lottery.common.Constants;
import com.moon.lottery.domain.award.model.req.DistributionReq;
import com.moon.lottery.domain.award.model.res.DistributionRes;
import com.moon.lottery.domain.award.service.factory.DistributionGoodsFactory;
import com.moon.lottery.domain.award.service.goods.IDistributionGoods;
import com.moon.lottery.domain.strategy.model.req.DrawReq;
import com.moon.lottery.domain.strategy.model.res.DrawRes;
import com.moon.lottery.domain.strategy.model.vo.DrawAwardInfo;
import com.moon.lottery.domain.strategy.service.draw.IDrawExec;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/14
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class DrawTest {


    @Resource
    private IDrawExec drawExec;

    @Autowired
    private DistributionGoodsFactory distributionGoodsFactory;


    @Test
    public void testDrawing() {
        Long strategyId = 10001L;
        Long uId = 99L;
        DrawReq req = new DrawReq(strategyId, uId);
        DrawRes res = drawExec.drawExec(req);
        Integer state = res.getDrawState();

        if (Constants.DrawState.FAILURE.getCode().equals(state)) {
            log.info("未中奖 uId: {}, strategyId: {}", uId, strategyId);
            return;
        }

        Long awardId = res.getDrawAwardInfo().getAwardId();
        Long orderId = 199999L;
        DistributionReq distributionReq = new DistributionReq(res.getUId(), orderId, awardId);
        IDistributionGoods service = distributionGoodsFactory.getDistributionGoodsService(Constants.AwardType.COUPON.getCode());
        DistributionRes distributionRes = service.distribute(distributionReq);
        log.info("已中奖 {}", JSON.toJSONString(distributionRes));


    }

}
