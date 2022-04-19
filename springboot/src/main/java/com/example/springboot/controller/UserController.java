package com.example.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springboot.bean.User;
import com.example.springboot.service.UserPlusService;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 *
 */

@RestController
public class UserController {

    private UserService userService;

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public void getUserList(){
        List<User> userList = userService.getUserList();
    }

    @RequestMapping(path = "/user", method = RequestMethod.POST)
    public int insertUser(@RequestBody User user){
        return userService.insertUser(user);
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public List<User> selectAllUser(){
        return userService.selectAllUser();
    }

    @RequestMapping(path = "/user/saveOrUpdate", method = RequestMethod.POST)
    public boolean saveOrUpdate(@RequestBody User user){
        return userService.saveOrUpdate(user);
    }

    @RequestMapping(path = "/user/count", method = RequestMethod.GET)
    public long count(@RequestBody User user){
        return userService.count(user);
    }

    @RequestMapping(path = "/user/selectAll1", method = RequestMethod.GET)
    public List<User> selectAll1(@RequestBody User user){
        return userService.selectAll1(user);
    }

    @RequestMapping(path = "/user/selectById", method = RequestMethod.GET)
    public List<User> count(@RequestParam("id") int id){
        System.out.println("id = " + id);
        return userService.selectById(id);
    }


    @Autowired
    public void setAppService(UserService appService) {
        this.userService = appService;
    }


}
