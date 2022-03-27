package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("user")
@Controller
public class UserController {
    @RequestMapping(headers = "dogHead",path = {"register",  "register1","register2"})
    public void getParam(String name,Integer age){
        System.out.println(name+"+"+age);
    }
}
