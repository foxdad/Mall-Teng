package com.lt.sms.controller;

import com.lt.common.Result;
import com.lt.sms.service.SmsService;
import com.lt.sms.utils.ComputeTimestamp;
import com.lt.sms.utils.RandomUtils;
import com.lt.sms.utils.SmsConstant;
import com.lt.sms.enums.SmsResultMessageEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author xiaohu
 * @version 1.0
 * @date 2021/2/5 22:11
 */

@Api(tags = "发送短信接口")
@Validated
@RestController
public class SmsController {

    @Autowired
    SmsService smsService;

    @Autowired
    StringRedisTemplate redisTemplate;

    /**
     * 发送短信接口
     * @param phone
     * @return
     */
    @ApiOperation("发送短信接口")
    @GetMapping("/send/{phone}")
    public Result<Object> send (@PathVariable("phone")@NotNull(message = "bad request") String phone) {

        String code  = redisTemplate.opsForValue().get(SmsConstant.SMS_PREFIX_KEY + phone);
        //判断验证码有限期是否是五分钟内的时间
        if (StringUtils.hasText(code)) {
            String[] codeTime = code.split(":");
            boolean timeFlag = ComputeTimestamp.computeTimestamp(codeTime[1]);
            //没有超过5分钟了
            if (timeFlag) {
                return new Result<>().filed(SmsResultMessageEnum.SmsTimeout.getMessage());
            }
        }
        Map<String,Integer> codeMap = new HashMap<>();
        int randomCode = RandomUtils.getRandom();
        codeMap.put(SmsConstant.SMS_MAP_KEY,RandomUtils.getRandom());
        boolean sendFlag = smsService.send(phone, codeMap);
        if (sendFlag) {
            //存入到redis中
            redisTemplate.opsForValue().set(SmsConstant.SMS_MAP_KEY+phone,code+":"+System.currentTimeMillis()/1000,301, TimeUnit.SECONDS);
            return new Result<>().success(SmsResultMessageEnum.SmsSuccess.getMessage());
        }
        return new Result<>().filed(SmsResultMessageEnum.SmsFiled.getMessage());

    }
}
