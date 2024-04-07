package com.moon.lottery.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/5
 */
public class Constants {


    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public enum ResponseCode {

        SUCCESS("0000", "Success."),
        UNKNOWN_ERROR("0001", "Unknown error."),
        ILLEGAL_PARAMETER("0002", "Illegal parameter."),
        INDEX_DUPLICATE("0003", "Index duplicate.");

        private String code;
        private String info;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public enum StrategyMode {

        FIXED(1, "Fixed Probability"),
        LIMITED(2, "Limited Quantity");

        private Integer code;
        private String info;
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public enum DrawState {

        FAILURE(0, "未中奖"),
        SUCCESS(1, "已中奖"),
        DEFAULT(2, "默认奖");

        private Integer code;
        private String info;
    }
}
