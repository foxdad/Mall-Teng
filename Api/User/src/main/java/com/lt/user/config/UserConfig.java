package com.lt.user.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaohu
 * @version 1.0
 * @date 2021/2/2 23:05
 * 所有的配置都在这里
 */
@Configuration
@MapperScan("com.lt.user.mapper")
@ComponentScan("com.lt.common")
public class UserConfig {



}
