package com.moon.lottery.domain.strategy.model.res;

import com.moon.lottery.common.Constants;
import com.moon.lottery.domain.strategy.model.vo.DrawAwardInfo;
import lombok.*;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/6
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DrawRes {

    private Long strategyId;

    private Long uId;

    // 0未中奖、1已中奖、2默认奖
    private Integer drawState = Constants.DrawState.FAILURE.getCode();

    private DrawAwardInfo drawAwardInfo;

    public DrawRes(Long strategyId, Long uId, Integer drawState) {
        this.strategyId = strategyId;
        this.uId = uId;
        this.drawState = drawState;
    }
}
