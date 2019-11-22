package com.atguigu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 在这里的controller是写在主配置类（@SpringBootApplication标注的类）所在的包或者其下面所有的子包里面的所有组件
 * 都可以被扫描到spring容器中，但是如果超出这个之外就不可以了
 */
@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "Hello World !";
    }

}
