package com.lt.sms.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author xiaohu
 * @version 1.0
 * @date 2021/2/5 22:14
 */
@Component
//读取配置文件的前缀
@ConfigurationProperties(prefix = "sms")
//读取的配置文件
@PropertySource(value = "sms.properties")
@Data
public class SmsConfigProperties {


    private  String ACCESS_KEY_ID;
    private String ACCESS_KEY_SECRET;
    private String ENDPOINT;
    private String SIGN_NAME;
    private  String TEMPLATE_CODE;
    private String REGION_ID;
    private String ENDPOINT_NAME;
    private String PRODUCT;
    private String DEFAULT_DOMAIN;

    public static String accessKeyId;
    public static String accessKeySecret;
    public static String endpoint;
    public static String signName;
    public static String templateCode;
    public static String regionId;
    public static String endpointName;

    public static String  product;
    public static String defaultDomain;

    //或者实现InitializingBean 重新初始话bean的 afterPropertiesSet 设置属性

    @PostConstruct
    public void setData() {
        accessKeyId = ACCESS_KEY_ID;
        accessKeySecret = ACCESS_KEY_SECRET;
        ENDPOINT = endpoint;
        SIGN_NAME = signName;
        TEMPLATE_CODE = templateCode;
        regionId = REGION_ID;
        endpointName = ENDPOINT_NAME;
        product = PRODUCT;
        defaultDomain = DEFAULT_DOMAIN;
    }





}
