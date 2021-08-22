package com.example.starter.mystarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(HelloProperties.class)
@ConditionalOnClass(HelloService.class)
@ConditionalOnWebApplication
public class HelloAutoConfiguration {
    
    @Autowired
    HelloProperties helloProperties;
    @Bean
    HelloService helloService(){
        HelloService helloService=new HelloService();
        helloService.setName(helloProperties.getName());
        return helloService;
    }
}