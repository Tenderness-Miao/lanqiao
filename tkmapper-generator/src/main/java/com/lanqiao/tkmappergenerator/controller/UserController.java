package com.lanqiao.tkmappergenerator.controller;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanqiao.tkmappergenerator.dao.UserMapper;
import com.lanqiao.tkmappergenerator.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    // 分页查询结果封装成PageInfo
    @GetMapping("/queryReturnPageInfo")
    public PageInfo queryReturnPageInfo(@RequestParam("pageNum") Integer pageNum,
            @RequestParam("pageSize") Integer pageSize) {
        // pageNum页码，pageSize每页显示的内容
        PageHelper.startPage(pageNum, pageSize);
        // 紧跟着的第一个select方法会被分页,后续的不会
        List<User> users = userMapper.selectAll();
        // 查询数据集封装成 PageInfo
        PageInfo pageInfo = new PageInfo(users);
        return pageInfo;
    }
}