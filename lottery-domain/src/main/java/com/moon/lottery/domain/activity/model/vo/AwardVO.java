package com.moon.lottery.domain.activity.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AwardVO {

    private Long awardId;

    private Integer awardType;

    private String awardName;

    private String awardContent;

}
