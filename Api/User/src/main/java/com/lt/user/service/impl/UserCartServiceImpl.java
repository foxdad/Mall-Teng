package com.lt.user.service.impl;

import com.lt.user.entity.UserCart;
import com.lt.user.mapper.UserCartMapper;
import com.lt.user.service.UserCartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 购物车 服务实现类
 * </p>
 *
 * @author xiaohu
 * @since 2021-02-02
 */
@Service
public class UserCartServiceImpl extends ServiceImpl<UserCartMapper, UserCart> implements UserCartService {

}
