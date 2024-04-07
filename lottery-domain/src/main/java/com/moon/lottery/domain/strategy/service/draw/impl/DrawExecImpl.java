package com.moon.lottery.domain.strategy.service.draw.impl;

import com.moon.lottery.domain.strategy.service.algorithm.IAlgorithm;
import com.moon.lottery.domain.strategy.service.draw.AbstractDraw;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;
import java.util.List;


/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/6
 */
@Service
@Slf4j
public class DrawExecImpl extends AbstractDraw {

    @Override
    protected Long drawAlgorithm(Long strategyId, IAlgorithm algorithm, List<Long> excludeAwardIds) {
        Long awardId = algorithm.randomDraw(strategyId, excludeAwardIds);
        if (awardId == -1L) {
            return awardId;
        }

        boolean deductSuccess = this.deductAward(awardId);

        return deductSuccess ? awardId : -1L;
    }

    @Override
    protected List<Long> queryExcludeAwardIds(Long strategyId) {
        List<Long> awardIds = super.queryNoSurplusAwardIds(strategyId);
        log.info("执行抽奖策略 {}, 排除列表奖品集合: {}", strategyId, JSON.toJSONString(awardIds));
        return awardIds;
    }
}
