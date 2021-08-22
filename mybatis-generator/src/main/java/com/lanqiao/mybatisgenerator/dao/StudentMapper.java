package com.lanqiao.mybatisgenerator.dao;

import com.lanqiao.mybatisgenerator.entity.Student;
import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    Student selectByPrimaryKey(Integer id);

    List<Student> selectAll();

    int updateByPrimaryKey(Student record);
}