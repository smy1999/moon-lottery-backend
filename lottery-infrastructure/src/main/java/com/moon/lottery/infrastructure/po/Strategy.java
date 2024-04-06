package com.moon.lottery.infrastructure.po;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/5
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Strategy {

    private Long id;

    private Long strategyId;

    private String strategyDesc;

    private Integer strategyMode;

    private Integer grantType;

    private LocalDateTime grantDate;

    private String extInfo;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
