package com.example.config.controller;

import com.example.config.bean.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class CourseController {
    @Autowired
    private Course course;

    @RequestMapping(value="/course", method=RequestMethod.GET)
    public String getCourse() {
        return course.toString();
    }
    
}