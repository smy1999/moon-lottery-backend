package com.moon.lottery.infrastructure.po;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/6
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Award {

    private Long id;

    private String awardId;

    private Integer awardType;

    private String awardName;

    private String awardContent;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
