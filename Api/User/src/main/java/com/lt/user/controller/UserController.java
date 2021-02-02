package com.lt.user.controller;


import com.lt.common.Result;
import com.lt.user.entity.vo.RegistryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author xiaohu
 * @since 2021-02-02
 */
@Api(tags = "用户接口")
@Validated
@RestController
@RequestMapping("/user")
public class UserController {

    @ApiOperation("手机号注册接口")
    @PostMapping("/registry")
    public Result<Object> registryUser (@Valid @RequestBody RegistryVo registryVo) {

        System.out.println("进来方法了");

        return null;
    }


}

