package com.moon.lottery.common;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/5
 */
public class Constants {

    public enum ResponseCode {

        SUCCESS("0000", "Success."),
        UNKNOWN_ERROR("0001", "Unknown error."),
        ILLEGAL_PARAMETER("0002", "Illegal parameter."),
        INDEX_DUPLICATE("0003", "Index duplicate.");

        private String code;
        private String info;

        ResponseCode(String code, String info) {
            this.code = code;
            this.info = info;
        }

        public String getCode() {
            return code;
        }

        public String getInfo() {
            return info;
        }
    }
}
