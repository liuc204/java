package com.example.springboot.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.bean.User;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 */

@Mapper
public interface UserMapper extends BaseMapper<User> {


}
