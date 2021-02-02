package com.lt.common.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author xiaohu
 * @version 1.0
 * @date 2021/2/2 21:43
 */
@Component
public class MybatisConfig implements MetaObjectHandler {


    @Override
    public void insertFill(MetaObject metaObject) {
       this.setFieldValByName("createTime",new Date(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("modifiedTime",new Date(),metaObject);

    }
}
