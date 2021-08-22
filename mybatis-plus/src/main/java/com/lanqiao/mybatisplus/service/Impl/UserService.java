package com.lanqiao.mybatisplus.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lanqiao.mybatisplus.dao.UserMapper;
import com.lanqiao.mybatisplus.entity.User;
import com.lanqiao.mybatisplus.service.IUserService;

import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper,User> implements IUserService{
    
}