package com.example.starter;

import com.example.starter.mystarter.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * Hello world!
 *
 */

@SpringBootApplication
@RestController
public class App 
{
    @Autowired
    HelloService helloService;
    @RequestMapping("/hello")
    public String hello() {
        return helloService.sayHello();
    }
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
