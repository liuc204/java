package com.example.springboot.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *
 */

@Mapper
public interface UserMapper extends BaseMapper<User> {

//    List<User> selectAll();

//    boolean saveOrUpdate(User user);
}
