package com.lanqiao.tkmapper.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;
  
@Table(name="tb_user")
@Data
public class User {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer userId;
    @Column(name="user_name")
    private String name;
    private Integer userAge;
}