package com.lanqiao.mybatismultidatasource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

import com.lanqiao.mybatismultidatasource.dao.shiyanlou01.TeacherMapper;
import com.lanqiao.mybatismultidatasource.dao.shiyanlou02.StudentMapper;
import com.lanqiao.mybatismultidatasource.entity.Student;
import com.lanqiao.mybatismultidatasource.entity.Teacher;

// 用于接口的在线测试
@EnableSwagger2
@RestController
public class TestController {

    // 从容器中获取teacherMapper（dataSource01操作）
    @Autowired
    private TeacherMapper teacherMapper;

    // 从容器中获取studentMapper（dataSource02操作）
    @Autowired
    private StudentMapper studentMapper;

    /**
     * 从shiyanlou01数据库中查询所有教师信息
     */
    @GetMapping("/teacher")
    public List<Teacher> findAllTeacher() {
        List<Teacher> teachers = teacherMapper.findAll();
        return teachers;
    }

    /**
     * 从shiyanlou02数据库中查询所有学生信息
     */
    @GetMapping("/student")
    public List<Student> findAllStudent() {
        List<Student> students = studentMapper.findAll();
        return students;
    }

}