package com.moon.lottery.application.process.res;

import com.moon.lottery.common.Result;
import com.moon.lottery.domain.strategy.model.vo.DrawAwardInfo;
import lombok.Data;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/7/1
 */
@Data
public class DrawProcessResult extends Result {

    private DrawAwardInfo drawAwardInfo;

    public DrawProcessResult(String code, String info) {
        super(code, info);
    }
}
