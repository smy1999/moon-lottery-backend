package com.moon.lottery.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @description: 封装结果
 * @author: smy1999
 * @date: 2024/4/5
 */

@Setter
@Getter
@AllArgsConstructor
public class Result implements Serializable {

    private static final long serialVersionUID = -3826891916021780628L;

    private String code;

    private String info;

    public static Result buildResult(String code, String info) {
        return new Result(code, info);
    }

    public static Result buildErrorResult(String code, String info) {
        return new Result(code, info);
    }

    public static Result buildErrorResult(String info) {
        return new Result(Constants.ResponseCode.UNKNOWN_ERROR.getCode(), info);
    }

    public static Result buildErrorResult() {
        return new Result(Constants.ResponseCode.UNKNOWN_ERROR.getCode(), Constants.ResponseCode.UNKNOWN_ERROR.getInfo());
    }

    public static Result buildSuccessResult() {
        return new Result(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo());
    }

}
