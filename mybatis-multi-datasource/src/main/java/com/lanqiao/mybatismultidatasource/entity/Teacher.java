package com.lanqiao.mybatismultidatasource.entity;

import lombok.Data;

@Data
public class Teacher {
    private Integer id;
    private String name;
    /**
     * 所教课程
     */
    private String course;
}