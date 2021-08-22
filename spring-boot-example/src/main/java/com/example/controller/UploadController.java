package com.example.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UploadController {
    @Value("${file.upload.path}")
    String fileUploadPath;

    @PostMapping(value="/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
       if (file.isEmpty()) {
           return "上传失败";
       }

       String fileName = System.currentTimeMillis()+file.getOriginalFilename();
       String destFileName=fileUploadPath+File.separator+fileName;
       try {
           byte[] bytes = file.getBytes();
           Path path = Paths.get(destFileName);
           Files.write(path,bytes);
       } catch (Exception e) {
           e.printStackTrace();
       }

       return "文件保存路径为"+destFileName;
    }
    
}