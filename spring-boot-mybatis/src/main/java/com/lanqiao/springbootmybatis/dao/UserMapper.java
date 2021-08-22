package com.lanqiao.springbootmybatis.dao;

import java.util.List;

import com.lanqiao.springbootmybatis.entity.User;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    @Select("select user_id,user_name,user_age from tb_user")
    List<User> findAll();

    @Select("select user_id,user_name,user_age from tb_user where user_id=#{userId}")
    User findById(Integer userId);

    @Insert("insert into tb_user (user_id,user_name,user_age) values(#{userId},#{userName},#{userAge})")
    Integer insert(User user);

    @Update("update tb_user set user_name = #{userName} where user_id = #{userId}")
    Integer update(Integer userId,String userName);

    @Delete("delete from tb_user where user_id = #{userId}")
    Integer delete(Integer userId);
}