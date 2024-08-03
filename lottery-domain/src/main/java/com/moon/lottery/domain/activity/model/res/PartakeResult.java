package com.moon.lottery.domain.activity.model.res;

import com.moon.lottery.common.Result;
import lombok.Data;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/5/25
 */
@Data
public class PartakeResult extends Result {

    private Long strategyId;

    private Long takeId;

    public PartakeResult(String code, String info) {
        super(code, info);
    }
}
