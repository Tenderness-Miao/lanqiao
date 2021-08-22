package com.example.config.controller;

import com.example.config.bean.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UserController {
    @Autowired
    private User user;

    @RequestMapping(value="/user", method=RequestMethod.GET)
    public String getUser() {
        return user.toString();
    }
    
}