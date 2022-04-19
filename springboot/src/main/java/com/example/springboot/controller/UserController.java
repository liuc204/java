package com.example.springboot.controller;

import com.example.springboot.bean.User;
import com.example.springboot.service.UserPlusService;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    public void setAppService(UserService appService) {
        this.userService = appService;
    }


}
