package com.moon.lottery.domain.strategy.service.algorithm;

import com.moon.lottery.domain.strategy.model.vo.AwardRateInfo;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/5
 */
@Slf4j
public abstract class BaseAlgorithm implements IAlgorithm {


    // 存放位置和awardId的桶
    protected Map<Long, Long[]> bucketMap = new ConcurrentHashMap<>();

    // 存放策略id与其对应的AwardRateInfo(AwardId, AwardRate)
    protected Map<Long, List<AwardRateInfo>> awardRateInfoMap = new ConcurrentHashMap<>();

    /**
     * 初始化
     * @param strategyId
     * @param awardRateInfoList
     */
    @Override
    public void initBucket(Long strategyId, List<AwardRateInfo> awardRateInfoList) {
        awardRateInfoMap.put(strategyId, awardRateInfoList);
    }

    @Override
    public boolean existsBucket(Long strategyId) {
        return awardRateInfoMap.containsKey(strategyId);
    }

}
