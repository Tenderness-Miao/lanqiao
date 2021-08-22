package com.lanqiao.mybatisplus.controller;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lanqiao.mybatisplus.entity.User;
import com.lanqiao.mybatisplus.service.Impl.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String list() {
        List<User> list = userService.list();
        return list.toString();
    }

    @GetMapping("/queryByAge")
    public String queryByAge(Integer age){
        List<User> list = userService.list(new QueryWrapper<User>().isNotNull("user_name").ge("user_age", age));
        return list.toString();
    }

    @PostMapping("/save")
    public boolean save(String userName,Integer userAge) {
        User user = new User();
        user.setUserName(userName);
        user.setUserAge(userAge);
        return userService.save(user);
    }

    @DeleteMapping("/delete")
    public boolean delete(Integer userId) {
        return userService.removeById(userId);
    }

    @PutMapping("/update")
    public boolean update(User user) {
        return userService.updateById(user);
    }

    @GetMapping("/page")
    public Page<User> page(Integer pageNum,Integer pageSize) {
        Page<User> userPage = new Page<>();
        userPage.setCurrent(pageNum);
        userPage.setSize(pageSize);
        Page<User> pageByWrapper = userService.page(userPage,new LambdaQueryWrapper<User>().isNotNull(User::getUserName));
        return pageByWrapper;
    }
}