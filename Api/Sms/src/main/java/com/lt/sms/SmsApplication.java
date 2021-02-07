package com.lt.sms;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author xiaohu
 * @version 1.0
 * 还是会记录要装配的短信发送记录数据库
 * @date 2021/2/7 21:13
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SmsApplication {
    public static void main(String[] args) {

        SpringApplication.run(SmsApplication.class,args);
    }
}
