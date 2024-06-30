package com.moon.lottery.dao;

import com.alibaba.fastjson.JSON;
import com.moon.lottery.BaseTest;
import com.moon.lottery.infrastructure.dao.IUserTakeActivityCountDao;
import com.moon.lottery.infrastructure.po.UserTakeActivityCount;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/30
 */
@Slf4j
public class UserTakeActivityCountDaoTest extends BaseTest {

    @Resource
    private IUserTakeActivityCountDao dao;

    @Test
    public void testQuery() {

        UserTakeActivityCount req = new UserTakeActivityCount();
        req.setActivityId(9L);
        req.setUId(1L);

        UserTakeActivityCount userTakeActivityCount = dao.queryUserTakeActivityCount(req);
        log.info("{}", JSON.toJSONString(userTakeActivityCount));

        req.setActivityId(2L);
        req.setUId(1L);
        UserTakeActivityCount userTakeActivityCount1 = dao.queryUserTakeActivityCount(req);
        log.info("{}", JSON.toJSONString(userTakeActivityCount1));

    }
}
