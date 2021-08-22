package com.lanqiao.tkmapper.dao;

import com.lanqiao.tkmapper.entity.User;

import org.springframework.stereotype.Repository;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Repository
public interface UserMapper extends Mapper<User>,MySqlMapper<User> {
    
}