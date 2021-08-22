package com.lanqiao.springbootmybatis.controller;

import java.util.List;

import com.lanqiao.springbootmybatis.dao.UserMapper;
import com.lanqiao.springbootmybatis.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@EnableSwagger2
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/findAll")
    public List<User> findAll() {
        List<User> users = userMapper.findAll();
        return users;
    }

    @GetMapping("/findById")
    public User finById(Integer id) {
        User user = userMapper.findById(id);
        return user;
    }

    @PostMapping("/insert")
    public String insert(User user) {
        userMapper.insert(user);
        return "插入成功，插入的数据为："+userMapper.findById(user.getUserId());
    }

    @PutMapping("/update")
    public String update(Integer id,String username) {
        userMapper.update(id,username);
        return "更新成功后的数据为："+userMapper.findById(id);
    }

    @DeleteMapping("/delete")
    public String delete(Integer id) {
        userMapper.delete(id);
        return "删除成功";
    }

}