package com.example.controller;

import com.example.domain.User;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 等价于 @Controller+@ResponseBody
 */
@RestController

public class UserController {
    /**
     * 创建线程安全的Map，模拟数据存储
     */
    static ConcurrentHashMap<Integer, User> users = new ConcurrentHashMap<Integer, User>();

    /**
     * 查询用户列表
     *
     * @return
     */
    @GetMapping("/users")
    @ApiOperation(value = "查询用户列表")
    public String getUsers() {

        return users.toString();
    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @PostMapping("/users")
    @ApiOperation(value = "添加用户")
    @ApiImplicitParam(name = "user",value = "用户",dataType = "User")
    public String addUser(@RequestBody User user) {
        users.put(user.getId(), user);
        return "添加成功";
    }

    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */
    @GetMapping("/users/{id}")
    @ApiOperation(value = "根据id查询用户信息")
    @ApiImplicitParam(name = "id", value = "用户ID", dataType = "Integer")
    public User getUser(@PathVariable("id") Integer id) {

        return users.get(id);
    }

    /**
     * 根据id更新用户信息
     *
     * @param id
     * @return
     */
    @PutMapping("/users/{id}")
    @ApiOperation(value = "根据id更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", dataType = "Integer"),
            @ApiImplicitParam(name = "user", value = "用户", dataType = "User")
    }
    )
    public String putUser(@PathVariable("id") Integer id, @RequestBody User user) {
        users.put(id, user);
        return "更新后数据为：" + users.get(id);
    }

    /**
     * 根据id删除用户信息
     *
     * @param id
     * @return
     */
    @DeleteMapping("/users/{id}")
    @ApiOperation(value = "根据id删除用户信息")
    @ApiImplicitParam(name = "id", value = "用户ID", dataType = "Integer")
    public String deleteUser(@PathVariable("id") Integer id) {
        users.remove(id);
        return "已经删除id=" + id + "的用户数据";
    }


}