package com.example.mydemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan("com.example.mydemo.mapper")
public class MydemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MydemoApplication.class, args);
    }

}

