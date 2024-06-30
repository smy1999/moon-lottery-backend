package com.moon.lottery.infrastructure.repository;

import com.moon.lottery.common.Constants;
import com.moon.lottery.domain.activity.model.req.PartakeReq;
import com.moon.lottery.domain.activity.model.vo.*;
import com.moon.lottery.domain.activity.repository.IActivityRepository;
import com.moon.lottery.infrastructure.dao.*;
import com.moon.lottery.infrastructure.po.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/17
 */
@Slf4j
@Repository
public class ActivityRepositoryImpl implements IActivityRepository {

    @Resource
    private IActivityDao activityDao;

    @Resource
    private IStrategyDao strategyDao;

    @Resource
    private IAwardDao awardDao;

    @Resource
    private IStrategyDetailDao strategyDetailDao;

    @Resource
    private IUserTakeActivityCountDao userTakeActivityCountDao;

    @Override
    public void addActivity(ActivityVO activityVO) {
        Activity activity = new Activity();
        BeanUtils.copyProperties(activityVO, activity);
        activity.setCreateTime(LocalDateTime.now());
        activity.setUpdateTime(LocalDateTime.now());

        activityDao.insertActivity(activity);

    }

    @Override
    public void addStrategy(StrategyVO strategyVO) {
        Strategy strategy = new Strategy();
        BeanUtils.copyProperties(strategyVO, strategy);
        strategy.setCreateTime(LocalDateTime.now());
        strategy.setUpdateTime(LocalDateTime.now());

        strategyDao.insertStrategy(strategy);
    }

    @Override
    public void addAward(List<AwardVO> awardVOList) {

        List<Award> awardList = new LinkedList<>();
        for (AwardVO awardVO : awardVOList) {
            Award award = new Award();
            BeanUtils.copyProperties(awardVO, award);
            award.setCreateTime(LocalDateTime.now());
            award.setUpdateTime(LocalDateTime.now());
            awardList.add(award);
        }

        awardDao.insertAwardList(awardList);

    }

    @Override
    public void addStrategyDetail(List<StrategyDetailVO> strategyDetailVOList) {

        List<StrategyDetail> strategyDetailList = new LinkedList<>();
        for (StrategyDetailVO strategyDetailVO : strategyDetailVOList) {
            StrategyDetail strategyDetail = new StrategyDetail();
            BeanUtils.copyProperties(strategyDetailVO, strategyDetail);
            strategyDetail.setCreateTime(LocalDateTime.now());
            strategyDetail.setUpdateTime(LocalDateTime.now());
            strategyDetailList.add(strategyDetail);
        }

        strategyDetailDao.insertStrategyDetailList(strategyDetailList);

    }

    @Override
    public Boolean alterStatus(Long activityId, Constants.ActivityState beforeState, Constants.ActivityState afterState) {
        AlterStateVO alterStateVO = new AlterStateVO();
        alterStateVO.setActivityId(activityId);
        alterStateVO.setBeforeState(beforeState.getCode());
        alterStateVO.setAfterState(afterState.getCode());

        Integer count = activityDao.alterState(alterStateVO);
        return count == 1;
    }

    @Override
    public ActivityBillVO queryActivityBill(PartakeReq req) {
        ActivityBillVO activityBillVO = new ActivityBillVO();
        Activity activity = activityDao.queryActivityByActivityId(req.getActivityId());

        BeanUtils.copyProperties(activity, activityBillVO);
        BeanUtils.copyProperties(req, activityBillVO);

        UserTakeActivityCount countReq = new UserTakeActivityCount();
        countReq.setUId(req.getUId());
        countReq.setActivityId(req.getActivityId());
        UserTakeActivityCount userTakeActivityCount = userTakeActivityCountDao.queryUserTakeActivityCount(countReq);
        if (Objects.nonNull(userTakeActivityCount)) {
            activityBillVO.setUserTakeLeftCount(userTakeActivityCount.getLeftCount());
        }

        return activityBillVO;
    }

    @Override
    public int subtractActivityStock(Long activityId) {
        return activityDao.subtractActivityStock(activityId);
    }

}
