package com.atguigu.elastic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot默认支持两种技术来和ES交互
 * 1，jest
 * 2,SpringData ElasticSearch
 * SpringData和ElasticSearch版本有可能不合适
 * 如果版本不匹配则通过
 * 1，升级SpringBoot版本
 * 2，安装对应版本的ES
 *
 */
@SpringBootApplication
public class Springboot03ElasticApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot03ElasticApplication.class, args);
    }

}
