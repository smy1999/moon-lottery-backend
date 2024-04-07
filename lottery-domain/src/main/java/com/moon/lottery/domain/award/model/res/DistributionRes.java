package com.moon.lottery.domain.award.model.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/7
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DistributionRes {

    private Long uId;

    // 编号
    private Integer code;

    // 描述
    private String info;

    // 结算单Id,发货后查询等
    private Long statementId;

    public DistributionRes(Long uId, Integer code, String info) {
        this.uId = uId;
        this.code = code;
        this.info = info;
    }
}
