package com.example.controller;

import com.example.exception.JsonException;
import com.example.exception.PageException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
    @RequestMapping(value = "/test")
    public String test() {
        System.out.println("test");
        return "success";
    }

    @GetMapping("/json")
    @ResponseBody
    public String jsonException() {
        throw new JsonException("服务器出错了", 500);
    }

    @GetMapping("/page")
    public ModelAndView pageException() {
        throw new PageException("服务器出错了", 500);
    }
}