package com.example.springboot.service;

import com.example.springboot.Mapper.UserMapper;
import com.example.springboot.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */

@Service
public class AppService {

    @Autowired
    UserMapper userMapper;

    public List<User> getUserList(){

        return userMapper.selectList(null);

    }

}
