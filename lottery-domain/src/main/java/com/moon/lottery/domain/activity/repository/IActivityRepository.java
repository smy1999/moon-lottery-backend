package com.moon.lottery.domain.activity.repository;

import com.moon.lottery.domain.activity.model.vo.ActivityVO;
import com.moon.lottery.domain.activity.model.vo.AwardVO;
import com.moon.lottery.domain.activity.model.vo.StrategyDetailVO;
import com.moon.lottery.domain.activity.model.vo.StrategyVO;

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
}
