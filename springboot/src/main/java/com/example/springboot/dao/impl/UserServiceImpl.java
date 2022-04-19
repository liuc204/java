package com.example.springboot.dao.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot.Mapper.UserMapper;
import com.example.springboot.bean.User;
import com.example.springboot.service.UserPlusService;
import org.springframework.stereotype.Component;

/**
 *
 */

@Component
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserPlusService {


}
