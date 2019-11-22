package com.atguigu.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

@SpringBootApplication
public class SpringBoot04WebRestfulcrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot04WebRestfulcrudApplication.class, args);
    }

    /**
     * 访问当前项目的任何资源（静态资源的文件夹）
     * classpath:/META-INF/resources/
     * classpath:/resources/
     * classpath:/static/
     * classpath:/public/
     * "/"：当前项目的根路径
     *
     * localhost:8080/abc === 去静态资源文件夹里面找abc
     * 欢迎页：态资源文件夹下的所有index.html页面；都被"/**"映射
     * localhost:8080/  找index页面
     *
     *
     */

    //所有的**/favicon.ico都是在静态资源文件夹下面找

    @Bean
    public ViewResolver myViewResolver(){
        return new MyViewResolver();
    }

    private static class MyViewResolver implements ViewResolver{

        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }
    }

}
