package com.example.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springboot.Mapper.UserMapper;
import com.example.springboot.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserPlusService userPlusService;

    public int insertUser(User user){
        return userMapper.insert(user);
    }

    public List<User> getUserList(){
        return userMapper.selectList(null);
    }

    public List<User> selectAllUser(){
        return userPlusService.list();
    }

    public boolean saveOrUpdate(User user){
        return userPlusService.saveOrUpdate(user);
    }
}
