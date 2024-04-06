package com.moon.lottery.domain.strategy.service.algorithm.impl;

import com.moon.lottery.domain.strategy.model.vo.AwardRateInfo;
import com.moon.lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 固定奖品数量,如果没了则无法再抽,strategy_mode=2
 * @author: smy1999
 * @date: 2024/4/5
 */
@Service
public class LimitedQuantityAlgorithm extends BaseAlgorithm {

    @Override
    public Long randomDraw(Long strategyId, List<Long> excludeAwardIds) {

        BigDecimal totalRate = BigDecimal.ZERO;

        List<AwardRateInfo> awardRateInfos = super.awardRateInfoMap.get(strategyId);
        List<AwardRateInfo> validRateInfos = new ArrayList<>();

        // 获取合理的Award List,并获取概率之和
        for (AwardRateInfo awardRateInfo : awardRateInfos) {
            if (excludeAwardIds.contains(awardRateInfo.getAwardId())) {
                continue;
            }
            validRateInfos.add(awardRateInfo);
            totalRate = totalRate.add(awardRateInfo.getAwardRate());
        }

        // 判断边界条件,如果没有合理的或者只有一个合理的,则直接返回
        if (0 == validRateInfos.size()) {
            return -1L;
        }
        if (1 == validRateInfos.size()) {
            return validRateInfos.get(0).getAwardId();
        }

        // 随机选取一个index
        int randomIndex = new SecureRandom().nextInt(100) + 1;

        int range = 0;
        Long awardId = -1L;
        for (AwardRateInfo awardRateInfo : validRateInfos) {
            // 计算概率/总概率*100,得到区间,递进判断是否
            int awardRange = awardRateInfo.getAwardRate().divide(totalRate, 2, RoundingMode.UP).multiply(BigDecimal.valueOf(100)).intValue();
            range += awardRange;
            if (range > randomIndex) {
                awardId = awardRateInfo.getAwardId();
                break;
            }
        }
        return awardId;
    }
}
