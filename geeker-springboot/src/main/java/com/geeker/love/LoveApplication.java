package com.geeker.love;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.geeker.love.dao")
public class LoveApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoveApplication.class, args);
    }
}
