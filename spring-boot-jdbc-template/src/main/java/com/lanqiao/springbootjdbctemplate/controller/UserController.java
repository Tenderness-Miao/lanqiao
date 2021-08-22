package com.lanqiao.springbootjdbctemplate.controller;

import java.util.List;
import java.util.Map;

import com.lanqiao.springbootjdbctemplate.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/queryAll")
    public String queryAll() {
        String selectSql = "select id,name,age from user";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(selectSql);
        return maps.toString();
    }

    @GetMapping("/queryById")
    public String queryById(int id) {
        String selectSql = "select id,name,age from user where id = ?";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(selectSql, id);
        return maps.toString();
    }

    @PostMapping("/add")
    public String addUser(User user) {
        String insertSql = "insert into user(id,name,age) values(?,?,?)";
        jdbcTemplate.update(insertSql,user.getId(),user.getName(),user.getAge());
        return "插入成功，插入的数据为" + this.queryById(user.getId());
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUeser(@PathVariable("id") int id) {
        String deleteSql = "delete from user where id = ?";
        jdbcTemplate.update(deleteSql,id);
        return "删除成功";
    }

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id, String name) {
        String updateSql = "update user set name = ? where id = ?";
        jdbcTemplate.update(updateSql, name, id);
        return "更新成功，更新后的数据为：" + this.queryById(id);
    }

}