package com.lt.user.controller;


import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.lt.common.Result;
import com.lt.common.utils.JwtUtils;
import com.lt.user.entity.vo.RegistryVo;
import com.lt.user.service.UserService;
import com.lt.user.utils.CodeUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

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

    @Autowired
    UserService userService;


    @ApiOperation("手机号登录接口")
    @PostMapping("/registry")
    public Result<Object> registryUser (@Valid @RequestBody RegistryVo registryVo) {

        System.out.println("进来方法了");
        //判断验证码是否正确

        //查询用户
        boolean registerFlag = userService.register(registryVo);
        if (registerFlag) {
            return new Result<>().success(registerFlag);
        }
        return new Result<>().filed();
    }
    @ApiOperation("生成二维码")
    @GetMapping(value = "/login-code")
    public void test(int type , HttpServletResponse response) throws Exception{
        // 设置响应流信息
        response.setContentType("image/jpg");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        OutputStream stream = response.getOutputStream();
        //type是1，生成活动详情、报名的二维码，type是2，生成活动签到的二维码
        String content = (type == 1 ? "http://www.baidu.com" : "http://www.jd.com");
        //获取一个二维码图片
        BitMatrix bitMatrix = CodeUtils.createCode(content);
//        System.out.println(Base64.encodeBase64String(bitMatrix.toString().getBytes(StandardCharsets.UTF_8)));
        //以流的形式输出到前端
        MatrixToImageWriter.writeToStream(bitMatrix , "jpg" , stream);
//        BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
//        InputStream is= com.lt.user.utils.MatrixToImageWriter.toInputStream(bufferedImage);
//        String imageStr = com.lt.user.utils.MatrixToImageWriter.getImageStr(is);
//        System.out.println(imageStr);
    }


    /**
     * 根据tocken获取用户信息
     * TODO 这个获取用户信息又可能会改变有问题
     * @return
     */
    @ApiOperation("根据tocken获取用户信息")
    @GetMapping("/getUserInfo")
    public Result<String> getUserInfo (HttpServletRequest request) {
        String userInfo = JwtUtils.getMemberIdByJwtToken(request);
        return new Result<>().success(userInfo);
    }




}

