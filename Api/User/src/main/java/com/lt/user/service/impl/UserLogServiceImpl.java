package com.lt.user.service.impl;

import com.lt.user.entity.UserLog;
import com.lt.user.mapper.UserLogMapper;
import com.lt.user.service.UserLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户登录日志表 服务实现类
 * </p>
 *
 * @author xiaohu
 * @since 2021-02-02
 */
@Service
public class UserLogServiceImpl extends ServiceImpl<UserLogMapper, UserLog> implements UserLogService {

}
