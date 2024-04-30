package com.moon.lottery.dao;

import com.moon.lottery.BaseTest;
import com.moon.lottery.infrastructure.dao.IUserTakeActivityDao;
import com.moon.lottery.infrastructure.po.UserTakeActivity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/30
 */
@Slf4j
public class UserTakeActivityDaoTest extends BaseTest {

    @Resource
    private IUserTakeActivityDao userTakeActivityDao;

    @Test
    public void testInsert() {
        UserTakeActivity userTakeActivity0 = new UserTakeActivity();

        userTakeActivity0.setUId("Uhdgkw766120d");
        userTakeActivity0.setTakeId(121019889410L);
        userTakeActivity0.setActivityId(100001L);
        userTakeActivity0.setActivityName("测试活动?库");
        userTakeActivity0.setTakeDate(LocalDateTime.now());
        userTakeActivity0.setTakeCount(10);
        userTakeActivity0.setUuid("Uhdgkw766120d");

        UserTakeActivity userTakeActivity1 = new UserTakeActivity();
        // 1库
        userTakeActivity1.setUId("Ukdli109op89oi");
        userTakeActivity1.setTakeId(121019889410L);
        userTakeActivity1.setActivityId(100001L);
        userTakeActivity1.setActivityName("测试活动1库");
        userTakeActivity1.setTakeDate(LocalDateTime.now());
        userTakeActivity1.setTakeCount(10);
        userTakeActivity1.setUuid("Ukdli109op89oi");

        UserTakeActivity userTakeActivity2 = new UserTakeActivity();
        // 2库
        userTakeActivity2.setUId("Ukdli109op811d");
        userTakeActivity2.setTakeId(121019889410L);
        userTakeActivity2.setActivityId(100001L);
        userTakeActivity2.setActivityName("测试活动2库");
        userTakeActivity2.setTakeDate(LocalDateTime.now());
        userTakeActivity2.setTakeCount(10);
        userTakeActivity2.setUuid("Ukdli109op811d");

        userTakeActivityDao.insert(userTakeActivity0);
        userTakeActivityDao.insert(userTakeActivity1);
        userTakeActivityDao.insert(userTakeActivity2);

    }
}
