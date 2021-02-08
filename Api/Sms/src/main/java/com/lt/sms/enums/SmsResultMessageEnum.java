package com.lt.sms.enums;

import com.lt.common.enums.ResultEnum;

/**
 * @author xiaohu
 * @version 1.0
 * @date 2021/2/8 21:17
 */
public enum SmsResultMessageEnum  {
    SmsSuccess("短信发送成功"),
    SmsFiled("短信发送失败"),
    SmsTimeout("短信发送操作频繁");


    private String message;

    SmsResultMessageEnum(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
