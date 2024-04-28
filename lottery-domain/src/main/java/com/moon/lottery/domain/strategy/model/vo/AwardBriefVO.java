package com.moon.lottery.domain.strategy.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AwardBriefVO {

    private String awardId;

    private Integer awardType;

    private String awardName;

    private String awardContent;

}
