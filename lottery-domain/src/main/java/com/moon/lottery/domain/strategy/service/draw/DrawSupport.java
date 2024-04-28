package com.moon.lottery.domain.strategy.service.draw;

import com.moon.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.moon.lottery.domain.strategy.model.vo.AwardBriefVO;
import com.moon.lottery.domain.strategy.repository.IStrategyRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: 这个类的作用就是将数据库交互的部分抽离出来，供 AbstractDraw 的使用
 * @author: smy1999
 * @date: 2024/4/6
 */
@Service
public class DrawSupport extends DrawConfig {

    @Resource
    private IStrategyRepository strategyRepository;

    protected StrategyRich queryStrategyRichByStrategyId(Long strategyId) {
        return strategyRepository.queryStrategyRichByStrategyId(strategyId);
    }

    protected AwardBriefVO queryAwardByAwardId(Long awardId) {
        return strategyRepository.queryAwardByAwardId(awardId);
    }

    /**
     * 查询没有剩余的award_id列表
     * @param strategyId
     * @return
     */
    protected List<Long> queryNoSurplusAwardIds(Long strategyId) {
        return strategyRepository.queryNoSurplusAwardIds(strategyId);
    }

    /**
     * 扣减商品数量
     * @param awardId
     * @return
     */
    protected boolean deductAward(Long awardId) {
        return strategyRepository.deductAward(awardId);
    }

}
