package com.yc.morty.myvueback.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yc.morty.myvueback.domain.User;
import com.yc.morty.myvueback.service.UserService;
import com.yc.morty.myvueback.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
implements UserService{
    @Autowired
    UserMapper userMapper;

}




