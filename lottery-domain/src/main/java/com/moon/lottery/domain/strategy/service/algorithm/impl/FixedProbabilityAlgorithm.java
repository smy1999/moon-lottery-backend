package com.moon.lottery.domain.strategy.service.algorithm.impl;

import com.moon.lottery.domain.strategy.model.vo.AwardRateInfo;
import com.moon.lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.List;

/**
 * @description: 固定概率,通过Fibonacci实现,strategy_mode=1
 * @author: smy1999
 * @date: 2024/4/5
 */
@Service
public class FixedProbabilityAlgorithm extends BaseAlgorithm {

    private final int HASH_INCREMENT = 0x61c88647;

    private final int BUCKET_LENGTH = 128;

    @Override
    public void initBucket(Long strategyId, List<AwardRateInfo> awardRateInfoList) {
        super.initBucket(strategyId, awardRateInfoList);

        Long[] bucket = new Long[BUCKET_LENGTH];
        int accumulateRate = 0;

        // 遍历策略细节,将每个位置对应的奖品置入lottery bucket中
        for (AwardRateInfo awardRateInfo : awardRateInfoList) {
            int rate = awardRateInfo.getAwardRate().multiply(BigDecimal.valueOf(100)).intValue();
            for (int i = accumulateRate + 1; i <= accumulateRate + rate; i++) {
                bucket[hashIndex(i)] = awardRateInfo.getAwardId();
            }
            accumulateRate += rate;
        }
        bucketMap.put(strategyId, bucket);
    }

    @Override
    public boolean existsBucket(Long strategyId) {
        return super.existsBucket(strategyId) && bucketMap.containsKey(strategyId);
    }

    /**
     * 利用bucket抽奖
     * @param strategyId
     * @param excludeAwardIds
     * @return
     */
    @Override
    public Long randomDraw(Long strategyId, List<Long> excludeAwardIds) {
        Long[] bucket = super.bucketMap.get(strategyId);
        assert bucket != null;

        int rawIndex = new SecureRandom().nextInt(100) + 1;
        int index = hashIndex(rawIndex);

        Long awardId = bucket[index];
        if (excludeAwardIds.contains(awardId)) {
            return -1L;
        }
        return awardId;
    }

    protected int hashIndex(int index) {
        int hashCode = index * HASH_INCREMENT + HASH_INCREMENT;
        return hashCode & (BUCKET_LENGTH - 1);
    }
}
