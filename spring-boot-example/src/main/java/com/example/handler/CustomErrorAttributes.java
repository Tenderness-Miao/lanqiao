package com.example.handler;

import java.util.Map;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

@Component
public class CustomErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String,Object> attributes = super.getErrorAttributes(webRequest, options);
        if(attributes.get("status").equals(404)){
            attributes.put("company", "shiyanlou");
        }
        return attributes;
    }
    
}