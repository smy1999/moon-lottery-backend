package com.moon.lottery.dao;

import com.moon.lottery.BaseTest;
import com.moon.lottery.common.Constants;
import com.moon.lottery.domain.support.ids.IIdGenerator;
import com.moon.lottery.infrastructure.dao.IUserStrategyExportDao;
import com.moon.lottery.infrastructure.po.UserStrategyExport;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/30
 */
@Slf4j
public class UserStrategyExportDaoTest extends BaseTest {

    @Resource
    private IUserStrategyExportDao userStrategyExportDao;

    @Resource
    private Map<Constants.Ids, IIdGenerator> idGeneratorMap;

    @Test
    public void testInsert() {
        UserStrategyExport userStrategyExport = new UserStrategyExport();
        userStrategyExport.setUId("Uhdgkw766120d");
        userStrategyExport.setActivityId(idGeneratorMap.get(Constants.Ids.SHORTCODE).nextId());
        userStrategyExport.setOrderId(idGeneratorMap.get(Constants.Ids.SNOWFLAKE).nextId());
        userStrategyExport.setStrategyId(idGeneratorMap.get(Constants.Ids.NUMERIC).nextId());
        userStrategyExport.setStrategyMode(Constants.StrategyMode.FIXED.getCode());
        userStrategyExport.setGrantType(1);
        userStrategyExport.setGrantDate(LocalDateTime.now());
        userStrategyExport.setGrantState(1);
        userStrategyExport.setAwardId(1L);
        userStrategyExport.setAwardType(Constants.AwardType.DESC.getCode());
        userStrategyExport.setAwardName("IMac");
        userStrategyExport.setAwardContent("奖品描述");
        userStrategyExport.setUuid(String.valueOf(userStrategyExport.getOrderId()));

        userStrategyExportDao.insert(userStrategyExport);
    }

    @Test
    public void testQuery() {
        UserStrategyExport userStrategyExport = userStrategyExportDao.queryUserStrategyExportByUId("Uhdgkw766120d");
        log.info("{}", userStrategyExport);
    }
}
