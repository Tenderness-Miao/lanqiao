package com.lanqiao.mybatisplus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lanqiao.mybatisplus.entity.User;

import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
    
}