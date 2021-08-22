package com.example.handler;

import com.example.exception.JsonException;
import com.example.exception.PageException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class DemoExceptionHandler {
    @ResponseBody
    @ExceptionHandler(JsonException.class)
    public String jsonErrorHandler(JsonException exception) {
        System.out.println("接口异常，返回Json数据");
        return exception.toString();
    }

    @ExceptionHandler(PageException.class)
    public ModelAndView pageErrorHandler(PageException exception) {
        System.out.println("页面返回异常，跳转到错误页面" + exception);
        ModelAndView view = new ModelAndView();
        view.setViewName("errorPage");
        view.addObject("message", exception.getMessage());
        return view;
    }
}