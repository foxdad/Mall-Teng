package com.lt.common;

import com.lt.common.enums.ResultEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author xiaohu
 * @version 1.0
 * @date 2021/2/2 23:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> implements Serializable {

    private int code;

    private String message;

    private T data;
    public Result (int code ,String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 成功
     * @param data
     * @return
     */
    public Result success(T data) {
        return new Result(ResultEnum.Success.getCode(), ResultEnum.Success.getMessage(), data);
    }


    /**
     * 请求失败
     * @return
     */
    public Result filed () {
        return new Result(ResultEnum.Filed.getCode(), ResultEnum.Filed.getMessage());
    }
    /**
     * 提示消息
     * @param code
     * @param message
     * @return
     */
    public Result tipMessage(int code ,String message) {
        return new Result(code,message);
    }




}
