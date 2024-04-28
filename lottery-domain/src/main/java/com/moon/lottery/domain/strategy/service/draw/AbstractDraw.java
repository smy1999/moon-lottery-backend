package com.moon.lottery.domain.strategy.service.draw;

import com.moon.lottery.common.Constants;
import com.moon.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.moon.lottery.domain.strategy.model.req.DrawReq;
import com.moon.lottery.domain.strategy.model.res.DrawRes;
import com.moon.lottery.domain.strategy.model.vo.*;
import com.moon.lottery.domain.strategy.service.algorithm.IAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/6
 */
@Service
@Slf4j
public abstract class AbstractDraw extends DrawSupport implements IDrawExec {

    @Override
    public DrawRes drawExec(DrawReq req) {
        // 1. 获取抽奖策略
        Long strategyId = req.getStrategyId();
        StrategyRich strategyRich = super.queryStrategyRichByStrategyId(strategyId);

        // 2. 检查是否初始化
        StrategyBriefVO strategy = strategyRich.getStrategy();
        Integer strategyMode = strategy.getStrategyMode();
        List<StrategyDetailBriefVO> strategyDetails = strategyRich.getStrategyDetailList();
        this.checkAndInitAlgorithm(strategyId, strategyMode, strategyDetails);

        // 3. 获取排除列表
        List<Long> excludeAwardIds = this.queryExcludeAwardIds(strategyId);

        // 4. 执行抽奖算法
        IAlgorithm algorithm = algorithmMap.get(strategyMode);
        Long awardId = this.drawAlgorithm(strategyId, algorithm, excludeAwardIds);

        // 5. 包装中奖结果
        return this.buildDrawResult(strategyId, req.getUId(), awardId);
    }

    private void checkAndInitAlgorithm(Long strategyId, Integer strategyMode, List<StrategyDetailBriefVO> strategyDetailList) {

        // 动态获取某个实现类
        IAlgorithm algorithm = algorithmMap.get(strategyMode);

        // 如果已经初始化了,则直接跳过
        if (algorithm.existsBucket(strategyId)) {
            log.info("{} 已经初始化完成.", algorithm.getClass().getSimpleName());
            return;
        }

        log.info("{} 进行初始化.", algorithm.getClass().getSimpleName());
        // 根据 List<StrategyDetail> 构建 List<AwardRateInfo>, 完成algorithm初始化
        List<AwardRateInfo> awardRateInfoList = new ArrayList<>(strategyDetailList.size());
        strategyDetailList.forEach(strategyDetail -> {
            AwardRateInfo awardRateInfo = new AwardRateInfo();
            BeanUtils.copyProperties(strategyDetail, awardRateInfo);
            awardRateInfoList.add(awardRateInfo);
        });

        algorithm.initBucket(strategyId, awardRateInfoList);
    }

    protected abstract Long drawAlgorithm(Long strategyId, IAlgorithm algorithm, List<Long> excludeAwardIds);

    protected abstract List<Long> queryExcludeAwardIds(Long strategyId);

    private DrawRes buildDrawResult(Long strategyId, Long uId, Long awardId) {
        // 没有抽中
        if (-1L == awardId) {
            log.info("未中奖 用户: {}, 策略: {}", uId, strategyId);
            return new DrawRes(strategyId, uId, Constants.DrawState.FAILURE.getCode());
        }
        // 抽中了
        AwardBriefVO award = super.queryAwardByAwardId(awardId);
        DrawAwardInfo drawAwardInfo = new DrawAwardInfo();
        BeanUtils.copyProperties(award, drawAwardInfo);
        log.info("已中奖 用户: {}, 策略: {}, 奖品: {} {}", uId, strategyId, awardId, drawAwardInfo.getAwardName());
        return new DrawRes(strategyId, uId, Constants.DrawState.SUCCESS.getCode(), drawAwardInfo);
    }


}