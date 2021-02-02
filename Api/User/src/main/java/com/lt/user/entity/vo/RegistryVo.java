package com.lt.user.entity.vo;

import com.lt.user.validation.MobilePattern;
import lombok.Data;

//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotNull;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author xiaohu
 * @version 1.0
 * @date 2021/2/2 23:53
 */
@Data
public class RegistryVo implements Serializable {

    @NotNull
    @MobilePattern
    private String phone;
    @NotNull(message = "验证码不能为空")
    private String veryCode;


}
