package com.furniro.furniture.services.uploadimage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.*;

@Configuration
public class ConfigImage implements WebMvcConfigurer {
    @Value("${image.upload.path}")
    private String uploadPath;

    public String getUploadPath() {
        return uploadPath;
    }

    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Initialize uploadPath here inside a method
//        Resource resource = resourceLoader.getResource(uploadPath);
//        System.out.println("Resource: " + resource);
//
//        try {
//            uploadPath = resource.getFile().getAbsolutePath();
//            System.out.println("Upload Path: " + uploadPath);
//        } catch (IOException e) {
//            // Handle the IOException appropriately (e.g., log the error)
//            e.printStackTrace();
//        }
//
//        registry.addResourceHandler("/uploads/**")
//                .addResourceLocations("classpath:/static/", "file:" + uploadPath);

    }
}
