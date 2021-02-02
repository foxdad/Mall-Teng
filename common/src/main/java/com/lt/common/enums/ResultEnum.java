package com.lt.common.enums;

import lombok.Data;

/**
 * @author xiaohu
 * @version 1.0
 * @date 2021/2/2 23:33
 */
public enum ResultEnum {

    Success(20000,"成功"),Filed(20001,"失败"),FiledParameter(20002,"验证参数错误");

    private int code;

    private String message;

    ResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
