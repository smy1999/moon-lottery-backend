package com.moon.lottery.infrastructure.repository;

import com.moon.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.moon.lottery.domain.strategy.model.vo.AwardBriefVO;
import com.moon.lottery.domain.strategy.model.vo.StrategyBriefVO;
import com.moon.lottery.domain.strategy.model.vo.StrategyDetailBriefVO;
import com.moon.lottery.domain.strategy.repository.IStrategyRepository;
import com.moon.lottery.infrastructure.dao.IAwardDao;
import com.moon.lottery.infrastructure.dao.IStrategyDao;
import com.moon.lottery.infrastructure.dao.IStrategyDetailDao;
import com.moon.lottery.infrastructure.po.Award;
import com.moon.lottery.infrastructure.po.Strategy;
import com.moon.lottery.infrastructure.po.StrategyDetail;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/5
 */
//@Repository
@Component
public class StrategyRepositoryImpl implements IStrategyRepository {

    @Resource
    private IStrategyDao strategyDao;

    @Resource
    private IStrategyDetailDao strategyDetailDao;

    @Resource
    private IAwardDao awardDao;

    @Override
    public StrategyRich queryStrategyRichByStrategyId(Long strategyId) {
        Strategy strategy = strategyDao.queryStrategyByStrategyId(strategyId);
        StrategyBriefVO strategyBriefVO = new StrategyBriefVO();
        BeanUtils.copyProperties(strategy, strategyBriefVO);

        List<StrategyDetail> strategyDetails = strategyDetailDao.queryStrategyDetailsByStrategyId(strategyId);
        List<StrategyDetailBriefVO> strategyDetailBriefVOs = new ArrayList<>();
        for (StrategyDetail strategyDetail : strategyDetails) {
            StrategyDetailBriefVO strategyDetailBriefVO = new StrategyDetailBriefVO();
            BeanUtils.copyProperties(strategyDetail, strategyDetailBriefVO);
            strategyDetailBriefVOs.add(strategyDetailBriefVO);
        }
        return new StrategyRich(strategyId, strategyBriefVO, strategyDetailBriefVOs);
    }

    @Override
    public AwardBriefVO queryAwardByAwardId(Long awardId) {
        AwardBriefVO awardBriefVO = new AwardBriefVO();
        Award award = awardDao.queryAwardByAwardId(awardId);
        BeanUtils.copyProperties(award, awardBriefVO);
        return awardBriefVO;
    }

    /**
     * 查询没有剩余的award_id列表
     * @param strategyId
     * @return
     */
    @Override
    public List<Long> queryNoSurplusAwardIds(Long strategyId) {
        return strategyDetailDao.queryNoSurplusAwardIds(strategyId);
    }

    /**
     * 根据影响行数,判断是否扣减成功
     * @param awardId
     * @return
     */
    @Override
    public boolean deductAward(Long awardId) {
        return strategyDetailDao.deductAward(awardId) > 0;
    }
}
