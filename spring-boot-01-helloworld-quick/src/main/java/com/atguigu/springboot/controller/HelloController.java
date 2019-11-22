package com.atguigu.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@ResponseBody注解加在类上表示这个类的所有方法的返回的数据直接写给浏览器，如果是对象的话还能够转为json数据
//@ResponseBody和@Controller注解可以被替换为@RestController
//@ResponseBody
//@Controller
@RestController
public class HelloController {

//    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "hello world quick!";
    }

    /**
     * resources文件夹的目录结构
     * static:保存所有的静态资源；js,css,images;
     * templates:保存所有的模板页面;（springboot默认jar包使用嵌入式的tomcat，默认不支持jsp页面）;可以使用模板引擎（freemarker,thymeleaf）
     *
     * application.properties:Spring Boor应用的配置文件，可以用来修改一些默认的配置
     *
     * SpringBoot使用一个全局的配置文件，配置文件名是固定的:
     * application.properties和application.yml
     *
     *
     */
}
