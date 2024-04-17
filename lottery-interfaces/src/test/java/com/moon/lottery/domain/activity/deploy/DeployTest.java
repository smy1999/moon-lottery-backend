package com.moon.lottery.domain.activity.deploy;

import com.moon.lottery.BaseTest;
import com.moon.lottery.common.Constants;
import com.moon.lottery.domain.activity.model.aggregates.ActivityConfigRich;
import com.moon.lottery.domain.activity.model.req.ActivityConfigReq;
import com.moon.lottery.domain.activity.model.vo.ActivityVO;
import com.moon.lottery.domain.activity.model.vo.AwardVO;
import com.moon.lottery.domain.activity.model.vo.StrategyDetailVO;
import com.moon.lottery.domain.activity.model.vo.StrategyVO;
import com.moon.lottery.domain.activity.service.deploy.IActivityDeploy;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/17
 */
public class DeployTest extends BaseTest {

    @Resource
    private IActivityDeploy activityDeploy;

    private ActivityConfigRich activityConfigRich;

    private Long activityId = 120981321L;

    @Before
    public void init() {

        ActivityVO activity = new ActivityVO();
        activity.setActivityId(activityId);
        activity.setActivityName("测试活动");
        activity.setActivityDesc("测试活动描述");
        activity.setBeginDateTime(LocalDateTime.now().minusMonths(1));
        activity.setEndDateTime(LocalDateTime.now());
        activity.setStockCount(100);
        activity.setTakeCount(10);
        activity.setState(1);
        activity.setCreator("xiaofuge");

        StrategyVO strategy = new StrategyVO();
        strategy.setStrategyId(10002L);
        strategy.setStrategyDesc("抽奖策略");
        strategy.setStrategyMode(Constants.StrategyMode.FIXED.getCode());
        strategy.setGrantType(1);
        strategy.setGrantDate(LocalDateTime.now());
        strategy.setExtInfo("");

        StrategyDetailVO strategyDetail_01 = new StrategyDetailVO();
        strategyDetail_01.setStrategyId(strategy.getStrategyId());
        strategyDetail_01.setAwardId(100001L);
        strategyDetail_01.setAwardName("一等奖");
        strategyDetail_01.setAwardCount(10);
        strategyDetail_01.setAwardSurplusCount(10);
        strategyDetail_01.setAwardRate(new BigDecimal("0.05"));

        StrategyDetailVO strategyDetail_02 = new StrategyDetailVO();
        strategyDetail_02.setStrategyId(strategy.getStrategyId());
        strategyDetail_02.setAwardId(100002L);
        strategyDetail_02.setAwardName("二等奖");
        strategyDetail_02.setAwardCount(20);
        strategyDetail_02.setAwardSurplusCount(20);
        strategyDetail_02.setAwardRate(new BigDecimal("0.15"));

        StrategyDetailVO strategyDetail_03 = new StrategyDetailVO();
        strategyDetail_03.setStrategyId(strategy.getStrategyId());
        strategyDetail_03.setAwardId(100003L);
        strategyDetail_03.setAwardName("三等奖");
        strategyDetail_03.setAwardCount(50);
        strategyDetail_03.setAwardSurplusCount(50);
        strategyDetail_03.setAwardRate(new BigDecimal("0.20"));

        StrategyDetailVO strategyDetail_04 = new StrategyDetailVO();
        strategyDetail_04.setStrategyId(strategy.getStrategyId());
        strategyDetail_04.setAwardId(100004L);
        strategyDetail_04.setAwardName("四等奖");
        strategyDetail_04.setAwardCount(100);
        strategyDetail_04.setAwardSurplusCount(100);
        strategyDetail_04.setAwardRate(new BigDecimal("0.25"));

        StrategyDetailVO strategyDetail_05 = new StrategyDetailVO();
        strategyDetail_05.setStrategyId(strategy.getStrategyId());
        strategyDetail_05.setAwardId(100005L);
        strategyDetail_05.setAwardName("五等奖");
        strategyDetail_05.setAwardCount(500);
        strategyDetail_05.setAwardSurplusCount(500);
        strategyDetail_05.setAwardRate(new BigDecimal("0.35"));

        List<StrategyDetailVO> strategyDetailList = new ArrayList<>();
        strategyDetailList.add(strategyDetail_01);
        strategyDetailList.add(strategyDetail_02);
        strategyDetailList.add(strategyDetail_03);
        strategyDetailList.add(strategyDetail_04);
        strategyDetailList.add(strategyDetail_05);

        strategy.setStrategyDetailList(strategyDetailList);

        AwardVO award_01 = new AwardVO();
        award_01.setAwardId(100001L);
        award_01.setAwardType(Constants.AwardType.DESC.getCode());
        award_01.setAwardName("电脑");
        award_01.setAwardContent("请联系活动组织者 fustack");

        AwardVO award_02 = new AwardVO();
        award_02.setAwardId(100002L);
        award_02.setAwardType(Constants.AwardType.DESC.getCode());
        award_02.setAwardName("手机");
        award_02.setAwardContent("请联系活动组织者 fustack");

        AwardVO award_03 = new AwardVO();
        award_03.setAwardId(100003L);
        award_03.setAwardType(Constants.AwardType.DESC.getCode());
        award_03.setAwardName("平板");
        award_03.setAwardContent("请联系活动组织者 fustack");

        AwardVO award_04 = new AwardVO();
        award_04.setAwardId(100004L);
        award_04.setAwardType(Constants.AwardType.DESC.getCode());
        award_04.setAwardName("耳机");
        award_04.setAwardContent("请联系活动组织者 fustack");

        AwardVO award_05 = new AwardVO();
        award_05.setAwardId(100005L);
        award_05.setAwardType(Constants.AwardType.DESC.getCode());
        award_05.setAwardName("数据线");
        award_05.setAwardContent("请联系活动组织者 fustack");

        List<AwardVO> awardList = new ArrayList<>();
        awardList.add(award_01);
        awardList.add(award_02);
        awardList.add(award_03);
        awardList.add(award_04);
        awardList.add(award_05);


        activityConfigRich = new ActivityConfigRich(activity, strategy, awardList);
    }

    @Test
    public void testCreateMethod() {
        ActivityConfigReq req = new ActivityConfigReq(9999L, activityConfigRich);
        activityDeploy.createActivity(req);
    }
}
