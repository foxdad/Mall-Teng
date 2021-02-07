package com.lt.user.service;

import com.lt.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lt.user.entity.vo.RegistryVo;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author xiaohu
 * @since 2021-02-02
 */
public interface UserService extends IService<User> {

    boolean register(RegistryVo registryVo);
}
