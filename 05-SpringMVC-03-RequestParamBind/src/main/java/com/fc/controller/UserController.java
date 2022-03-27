package com.fc.controller;

import com.fc.entity.Clazz;
import com.fc.entity.User;
import com.fc.entity.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Controller
@RequestMapping("user")
public class UserController {
    @RequestMapping(path = "testParam")
    public String testParam(String name, Integer age, String gender, String birthday, String info){
        System.out.println(name+"+"+age+"+"+gender+"+"+info+birthday);

        return "/success.jsp";
    }
    @RequestMapping(path = "testObject")
    public String testObject(User user){
        System.out.println(user);

        return "/success.jsp";
    }
    @RequestMapping("testNestedObject")
    public String testNestedObject(UserInfo userInfo){
        System.out.println(userInfo);
        return "/success.jsp";
    }
    @RequestMapping("testListAndList")
    public String testListAndList(Clazz clazz){
        System.out.println(clazz);
        return "/success.jsp";
    }
    @RequestMapping("testServlet")
    public void testServlet(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        request.getSession(true).setAttribute("username",username);
        try {
            request.getRequestDispatcher("/success.jsp").forward(request,response);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }
}
