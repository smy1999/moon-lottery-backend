package com.moon.lottery.repository;

import com.alibaba.fastjson.JSON;
import com.moon.lottery.domain.activity.model.req.PartakeReq;
import com.moon.lottery.domain.activity.model.vo.ActivityBillVO;
import com.moon.lottery.domain.activity.repository.IActivityRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/5
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class ActivityRepositoryTest {

    @Autowired
    private IActivityRepository activityRepository;


    @Test
    public void testQueryActivityBill() {
        Long activityId = 100001L;
        PartakeReq partakeReq = new PartakeReq();
        partakeReq.setActivityId(activityId);
        ActivityBillVO activityBillVO = activityRepository.queryActivityBill(partakeReq);
        log.info("{}", JSON.toJSONString(activityBillVO));
    }

}
