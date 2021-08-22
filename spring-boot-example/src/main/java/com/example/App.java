package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    // @GetMapping("/shiyanlou")
    // public String index(Model model) {
    //     ArrayList<User> users = new ArrayList<>();
    //     for (int i = 0; i < 10; i++) {
    //         User u = new User();
    //         u.setId(i);
    //         u.setName("shiyanlou:"+i);
    //         u.setAge(i+10);
    //         users.add(u);
    //     }

    //     model.addAttribute("course", "Spring boot 整合");
    //     model.addAttribute("users",users);
    //     return "shiyanlou";
    // }
}