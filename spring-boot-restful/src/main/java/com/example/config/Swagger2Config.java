package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Swagger2Config {
    @Bean
    public Docket creatRestApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2).pathMapping("/").select()
                .apis(RequestHandlerSelectors.basePackage("com.example.controller")).paths(PathSelectors.any()).build()
                .apiInfo(new ApiInfoBuilder().title("Spring boot 整合Swagger").description("文档描述信息").version("1.0")
                        .contact(new Contact("shiyanlou", "http://www.lanqiao.cn/", "shiyanlou.com"))
                        .license("The Apache License, Verison 2.0")
                        .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html").build());
        return docket;
    }
}