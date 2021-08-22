package com.example.starter.mystarter;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "shiyanlou")
public class HelloProperties {
    private static final String  DEFAULT_NAME="shiyanlou";
    private String name = DEFAULT_NAME;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}