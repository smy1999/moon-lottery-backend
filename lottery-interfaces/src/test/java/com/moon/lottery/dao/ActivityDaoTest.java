package com.moon.lottery.dao;

import com.alibaba.fastjson.JSON;
import com.moon.lottery.infrastructure.dao.IActivityDao;
import com.moon.lottery.infrastructure.po.Activity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/5
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ActivityDaoTest {

    @Resource
    private IActivityDao activityDao;

    @Test
    public void testInsert() {
        Activity activity = Activity.builder()
                .activityId(10001L)
                .activityName("TestActivity")
                .activityDesc("Test Description")
                .state(1)
                .beginDateTime(LocalDateTime.now())
                .endDateTime(LocalDateTime.now())
                .stockCount(5)
                .takeCount(4)
                .creator("TestUser")
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();
        activityDao.insertActivity(activity);
        List<Activity> all = activityDao.queryAllActivities();
        for (Activity act : all) {
            log.info("测试结果: {}", JSON.toJSONString(act));
        }
    }

    @Test
    public void testQuery() {
        Long activityId = 10001L;
        Activity activity = activityDao.queryActivityByActivityId(activityId);
        log.info("{}", JSON.toJSONString(activity));
    }
}
