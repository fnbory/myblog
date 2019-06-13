package com.fnbory.myblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//@EnableCaching
@SpringBootApplication
@MapperScan("com.fnbory.myblog.dao")
public class MyblogApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyblogApplication.class, args);
    }
}
