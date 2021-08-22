package com.lanqiao.mybatismultidatasource.dao.shiyanlou01;

import org.springframework.stereotype.Repository;

import java.util.List;

import com.lanqiao.mybatismultidatasource.entity.Teacher;

@Repository
public interface TeacherMapper {

     List<Teacher> findAll();
}