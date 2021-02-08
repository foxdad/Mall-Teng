package com.lt.sms.utils;

import java.util.Random;

/**
 * @author xiaohu
 * @version 1.0
 * @date 2021/2/8 21:25
 * 随机生成验证码
 */
public class RandomUtils {
    public static int getRandom() {
        Random random = new Random();
        int num = 1000;
        int res = random.nextInt(8999) + num;
        return res;
    }
}
