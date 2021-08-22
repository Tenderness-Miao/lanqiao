package com.lanqiao.tkmapper.controller;

import java.util.List;

import com.lanqiao.tkmapper.dao.UserMapper;
import com.lanqiao.tkmapper.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@EnableSwagger2
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping(value="/queryAll")
    public List<User> queryAll() {
        List<User> users= userMapper.selectAll();
        return users;
    }
    
    @GetMapping(value="/query")
    public User queryById(Integer id) {
        User user= userMapper.selectByPrimaryKey(id);
        return user;
    }
    
    @PutMapping(value="/insert")
    public int insert(@RequestParam("name") String name,@RequestParam("age") Integer age) {
        User user = new User();
        user.setName(name);
        user.setUserAge(age);
        return userMapper.insertUseGeneratedKeys(user);
    }

    @PostMapping(value="/update")
    public int update(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    @DeleteMapping(value = "delete")
    public int deleteById(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }
    
}