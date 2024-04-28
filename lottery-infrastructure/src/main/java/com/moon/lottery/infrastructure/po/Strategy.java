package com.moon.lottery.infrastructure.po;

import lombok.*;

import java.time.LocalDateTime;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/5
 */

@Data
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
