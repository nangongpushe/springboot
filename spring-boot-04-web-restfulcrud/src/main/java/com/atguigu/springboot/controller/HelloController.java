package com.atguigu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

    /**
     * 之所以写下面这个方法是因为在resources下面的public和templates都有index.html页面
     * 这个方法可以让我们访问到templates下面的index.html页面，不过不推荐这种方式，因为
     * 比较麻烦，推荐的是在MyMvcConfig类中写上映射即可
     *
     * @return
     */
//    @RequestMapping({"/","/index.html"})
//    public String index(){
//        return "index";
//    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }

    //查出一些数据在页面显示
    @RequestMapping("/success")
    public String success(Map<String, Object> map){
        map.put("hello","<h1>你好<h1/>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        return "success";
    }
}
