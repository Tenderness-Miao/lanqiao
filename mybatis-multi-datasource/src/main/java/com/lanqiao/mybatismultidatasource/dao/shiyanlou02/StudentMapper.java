package com.lanqiao.mybatismultidatasource.dao.shiyanlou02;

import com.lanqiao.mybatismultidatasource.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {

    List<Student> findAll();

}