package com.lt.sms.utils;

/**
 * @author xiaohu
 * @version 1.0
 * @date 2021/2/8 20:58
 */
public class ComputeTimestamp {

    /**
     * 计算秒时间差是否大于5分钟
     * @param dateString
     * @return
     */
    public static boolean computeTimestamp (String dateString) {
        Long second = Long.valueOf(dateString);
        long nowSecond = System.currentTimeMillis()/1000;
       return nowSecond-second<300?true:false;
    }


}
