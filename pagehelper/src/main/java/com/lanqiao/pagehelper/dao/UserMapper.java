package com.lanqiao.pagehelper.dao;

import com.lanqiao.pagehelper.entity.User;

import org.springframework.stereotype.Repository;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Repository
public interface UserMapper extends Mapper<User>,MySqlMapper<User> {
    
}