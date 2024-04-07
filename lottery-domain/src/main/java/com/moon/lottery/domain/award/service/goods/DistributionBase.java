package com.moon.lottery.domain.award.service.goods;

import com.moon.lottery.domain.award.repository.IAwardRepository;
import lombok.extern.slf4j.Slf4j;
import javax.annotation.Resource;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/7
 */
@Slf4j
public class DistributionBase {

    @Resource
    private IAwardRepository awardRepository;

    protected void updateUserAwardState(Long uId, Long orderId, Integer awardStateCode, String awardStateInfo) {
        // TODO: 分库分表之后,更新发奖状态
        log.info("等待后续更新用户 {} 发奖状态", uId);
    }
}
