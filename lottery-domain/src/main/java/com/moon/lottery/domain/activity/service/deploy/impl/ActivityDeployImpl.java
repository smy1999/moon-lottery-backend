package com.moon.lottery.domain.activity.service.deploy.impl;

import com.alibaba.fastjson.JSON;
import com.moon.lottery.domain.activity.model.aggregates.ActivityConfigRich;
import com.moon.lottery.domain.activity.model.req.ActivityConfigReq;
import com.moon.lottery.domain.activity.model.vo.ActivityVO;
import com.moon.lottery.domain.activity.model.vo.AwardVO;
import com.moon.lottery.domain.activity.model.vo.StrategyDetailVO;
import com.moon.lottery.domain.activity.model.vo.StrategyVO;
import com.moon.lottery.domain.activity.repository.IActivityRepository;
import com.moon.lottery.domain.activity.service.deploy.IActivityDeploy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/16
 */
@Service
@Slf4j
public class ActivityDeployImpl implements IActivityDeploy {

    @Resource
    private IActivityRepository activityRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createActivity(ActivityConfigReq activityConfigReq) {

        ActivityConfigRich activityConfigRich = activityConfigReq.getActivityConfigRich();
        log.info("Start creating activity: {}", JSON.toJSONString(activityConfigRich));

        try {
            // 依次添加不同内容
            ActivityVO activityVO = activityConfigRich.getActivityVO();
            activityRepository.addActivity(activityVO);

            StrategyVO strategyVO = activityConfigRich.getStrategyVO();
            activityRepository.addStrategy(strategyVO);

            List<AwardVO> awardList = activityConfigRich.getAwardList();
            activityRepository.addAward(awardList);

            List<StrategyDetailVO> strategyDetailList = strategyVO.getStrategyDetailList();
            activityRepository.addStrategyDetail(strategyDetailList);

            log.info("Finish creating activity: {}", JSON.toJSONString(activityConfigRich));

        } catch (DuplicateKeyException e) {
            log.info("Creation error: ActivityId duplicate. activityId: {}, req: {}", activityConfigReq.getActivityId(), JSON.toJSONString(activityConfigReq), e);
            throw e;
        }

    }

    @Override
    public void updateActivity(ActivityConfigReq activityConfigReq) {

    }
}
