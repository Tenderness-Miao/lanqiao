package com.example.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ExtendMvcConfige implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/test");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**").addResourceLocations("classpath:/upload/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("home.html");
    }

    class MyInterceptor implements HandlerInterceptor {

        @Override
        public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                Exception ex) throws Exception {
            System.out.println("最终完成");
        }

        @Override
        public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                ModelAndView modelAndView) throws Exception {
            System.out.println("后置处理完成");
        }

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
                throws Exception {
           System.out.println("前置处理完成");
           return true;
        }
        
    }
}