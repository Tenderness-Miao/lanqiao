package com.lanqiao.pagehelper.controller;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanqiao.pagehelper.dao.UserMapper;
import com.lanqiao.pagehelper.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@EnableSwagger2
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping(value = "/queryReturnUser")
    public List<User> queryRetuUser(@RequestParam("pageNum") Integer pageNum,
            @RequestParam("pageSize") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userMapper.selectAll();
        return users;
    }

    @GetMapping(value = "/queryReturnPageInfo")
    public PageInfo queryReturnPageInfo(@RequestParam("pageNum") Integer pageNum,
            @RequestParam("pageSize") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userMapper.selectAll();
        return new PageInfo(users);
    }

}