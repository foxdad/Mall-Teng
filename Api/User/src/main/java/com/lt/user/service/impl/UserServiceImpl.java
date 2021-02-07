package com.lt.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lt.user.entity.User;
import com.lt.user.entity.vo.RegistryVo;
import com.lt.user.mapper.UserMapper;
import com.lt.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author xiaohu
 * @since 2021-02-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    /**
     * 查询用户是否存在
     * @param registryVo
     * @return
     */
    @Override
    public boolean register(RegistryVo registryVo) {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_phone",registryVo.getPhone());
        User user = baseMapper.selectOne(queryWrapper);
        if (user!=null) {
            return true;
        }else{
            //添加用户
            User registerUser = new User();
            registerUser.setUserPhone(registerUser.getUserPhone());
            int result = baseMapper.insert(registerUser);
            return result==1?true:false;
        }
    }
}
