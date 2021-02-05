package com.lt.active.controller;


import com.lt.active.service.ActiveService;
import com.lt.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 活动表 前端控制器
 * </p>
 *
 * @author xiaohu
 * @since 2021-02-03
 */
@RestController
@Api(tags = "活动接口")
@RequestMapping("/active")
public class ActiveController {

    @Autowired
    ActiveService activeService;

    @ApiOperation("查询状态存在的活动")
    public Result<Object> getActive() {


        return null;
    }

}

