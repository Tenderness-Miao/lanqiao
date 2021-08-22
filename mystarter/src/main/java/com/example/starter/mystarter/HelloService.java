package com.example.starter.mystarter;

public class HelloService {
    private String name;
    public String sayHello(){
        return "hello "+name+"!";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}