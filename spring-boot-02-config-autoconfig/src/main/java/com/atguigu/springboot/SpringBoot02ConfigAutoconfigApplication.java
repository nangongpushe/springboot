package com.atguigu.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBoot02ConfigAutoconfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot02ConfigAutoconfigApplication.class, args);
    }

    /**
     * 在日志方面springboot采用SLF4j和logback，springboot底层是spring框架，spring框架默认使用的是JCL日志框架
     */
}
