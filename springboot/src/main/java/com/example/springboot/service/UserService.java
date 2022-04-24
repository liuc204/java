package com.example.springboot.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springboot.Mapper.UserMapper;
import com.example.springboot.bean.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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

    public long count(User user){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.eq("age", 20);
        return userPlusService.count(queryWrapper);
    }

    public List<User> selectAll1() {
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.eq("age", 30);
        return userMapper.selectAll1(wrapper);
    }

    public List<User> selectById(int id) {
        return userMapper.selectById(id);
    }

}
