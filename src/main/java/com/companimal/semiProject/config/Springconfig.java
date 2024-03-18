package com.companimal.semiProject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Springconfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/getCreatorFile/**")
                .addResourceLocations("file:///C:\\IntelliJ\\GitHub\\companimal-semi_project\\build\\resources\\main\\static\\img\\creatorFile\\");
//                .addResourceLocations("classpath:/static/");
    }

}
