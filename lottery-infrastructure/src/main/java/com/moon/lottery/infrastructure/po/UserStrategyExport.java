package com.moon.lottery.infrastructure.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/30
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserStrategyExport {
    private Long id;
    private String uId;
    private Long activityId;
    private Long orderId;
    private Long strategyId;

    /** 策略方式（1:单项概率、2:总体概率） */
    private Integer strategyMode;

    /** 发放奖品方式（1:即时、2:定时[含活动结束]、3:人工） */
    private Integer grantType;
    private LocalDateTime grantDate;
    private Integer grantState;
    private Long awardId;

    /** 奖品类型（1:文字描述、2:兑换码、3:优惠券、4:实物奖品） */
    private Integer awardType;
    private String awardName;
    private String awardContent;
    private String uuid;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
