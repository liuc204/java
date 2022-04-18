package com.example.springboot.controller;

import com.example.springboot.bean.User;
import com.example.springboot.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 */

@RestController
public class AppController {

    private AppService appService;


    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public void getUserList(){
        List<User> userList = appService.getUserList();
    }



    @Autowired
    public void setAppService(AppService appService) {
        this.appService = appService;
    }


}
