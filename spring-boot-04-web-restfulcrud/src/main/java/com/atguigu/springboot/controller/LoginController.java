package com.atguigu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    /**
     * @RequestMapping中带有请求方法的映射，可以换成@PostMapping或者其它，具体情况要依赖于方法
     * @param username
     * @param password
     * @param map
     * @return
     */
//    @DeleteMapping
//    @PutMapping
//    @GetMapping
//    @RequestMapping(value="/user/login",method = RequestMethod.POST)
    @PostMapping(value="/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map,
                        HttpSession session){
        if (!StringUtils.isEmpty(username) && "123456".equals(password)){
            //登录成功，防止表单重复提交，可以重定向到主页
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else {
            //登陆失败
            map.put("msg","用户名或密码错误");
            return "login";
        }

    }

}
