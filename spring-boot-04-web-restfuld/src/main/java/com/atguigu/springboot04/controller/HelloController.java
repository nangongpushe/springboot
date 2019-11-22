package com.atguigu.springboot04.controller;

import com.atguigu.springboot04.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

    /**
     * 之所以写下面这个方法是因为在resources下面的public和templates都有index.html页面
     * 这个方法可以让我们访问到templates下面的index.html页面，不过不推荐这种方式，因为
     * 比较麻烦，推荐的是在MyMvcConfig类中写上映射即可，不过呢下面这个方法的映射在访问时
     * 可能会报500的错误，这个时候需要重启一次idea就可以了，具体原因不知道
     *
     * @return
     */
//    @RequestMapping({"/","/index.html"})
//    public String index(){
//        return "index";
//    }

    @ResponseBody
    @RequestMapping("/hello")
    public  String hello(@RequestParam("user") String user){
        if(user.equals("aaa")){
            throw new UserNotExistException();
        }
        return "Hello World";
    }

    /**
     * http://localhost:8080/asserts/js/Chart.min.js这个访问地址报404错误，也不知道是什么原因，可是等了一会儿就可以访问了
     */

    //查出一些数据在页面显示
    @RequestMapping("/success")
    public String success(Map<String, Object> map){
        map.put("hello","<h1>你好<h1/>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        return "success";
    }

}
