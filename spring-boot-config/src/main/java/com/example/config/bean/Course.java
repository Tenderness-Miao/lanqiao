package com.example.config.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Course {
    @Value("${course.id}")
    private int courseId;
    @Value("${course.name}")
    private String courseName;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "Course [courseId=" + courseId + ", courseName=" + courseName + "]";
    }

}