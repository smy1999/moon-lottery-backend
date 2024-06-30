package com.moon.lottery.domain.activity.repository;

import com.moon.lottery.common.Constants;
import com.moon.lottery.domain.activity.model.req.PartakeReq;
import com.moon.lottery.domain.activity.model.vo.*;

import java.util.List;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/17
 */
public interface IActivityRepository {

    void addActivity(ActivityVO activityVO);

    void addStrategy(StrategyVO strategyVO);

    void addAward(List<AwardVO> awardVOList);

    void addStrategyDetail(List<StrategyDetailVO> strategyDetailVOList);

    Boolean alterStatus(Long activityId, Constants.ActivityState beforeState, Constants.ActivityState afterState);

    ActivityBillVO queryActivityBill(PartakeReq req);

    int subtractActivityStock(Long activityId);
}
