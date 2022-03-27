package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//将当前类注入到容器中
@Controller
//用于声明请求的url路径，和@WebServlet注解相同
@RequestMapping("user")
public class UserController {
    //方法上也能加resquestMapping注解,相当于二级路径
    @RequestMapping("login")
    public String login(){
        System.out.println("login");
        //指定页面跳转的路径，注意/从根目录起
        return "/login.jsp";
    }
    @RequestMapping("add")
    public String add(){
        System.out.println("add");
        //指定页面跳转的路径，注意/从根目录起
        return "/success.jsp";
    }
    @RequestMapping("update")
    public String update(){
        System.out.println("update");
        //指定页面跳转的路径，注意/从根目录起
        return "/success.jsp";
    }
}
