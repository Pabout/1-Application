package com.fc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fc.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("response")
public class ResponseController {
    @RequestMapping("testVoid")
    public void testVoid(){
        System.out.println("测试返回值是void");
    }
    @RequestMapping("testString")
    public String testString(){
        System.out.println("测试返回值是String");
        return "/success.jsp";
    }
    @RequestMapping("testMode")
    public ModelAndView testMode(){
        ModelAndView mv = new ModelAndView();
        //设置模型
        mv.addObject("username","易烊千玺");
        //设置视图
        mv.setViewName("/success.jsp");
        return mv;
    }
    @RequestMapping("testMode1")
    public String  testMode1(Model model){
        model.addAttribute("username","迪丽热巴");
        return "/success.jsp";
    }
    @RequestMapping("testRedirect")
    public void testRedirect(HttpServletResponse response){
        try {
            response.sendRedirect("/success.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("testForward")
    public void testForward(HttpServletRequest request,HttpServletResponse response){
        request.setAttribute("username","易烊千玺");

        try {
            request.getRequestDispatcher("/success.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("testStringRedirect")
    public String testStringRedirect(){
        return "redirect:/success.jsp";
    }
    @RequestMapping("testStringForward")
    public String testStringForward(Model model){
        model.addAttribute("username","玛卡巴卡");
        return "forward:/success.jsp";
    }
    @RequestMapping("testResponseBody")
    @ResponseBody
    public void testResponseBody(){
        System.out.println("测试@ResponseBody");
    }
    @RequestMapping("testResponseBodyString")
    @ResponseBody
    public String testResponseBodyString(){
        //如果使用字符串返回就相当于调用
        return "/success.jsp";
    }
    @RequestMapping(value = "testHTMLString",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String testHTMLString(){
        //如果使用字符串返回就相当于调用
        return "<h1 align='center' style='color:yellow'>迪丽热巴</h1>";
    }
    @RequestMapping(value = "testJsonObject",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String testJsonObject(){
        //如果使用字符串返回就相当于调用
        User user = new User();
        user.setName("易烊千玺");
        user.setAge(20);
        user.setGender("男");
        user.setBirthday(new Date());
        user.setInfo("真帅");
        //获取对象映射器
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            //将对象转换为对应的json字符
            json = objectMapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(json);
        return json;
    }
    @RequestMapping(value = "testMap",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String,Object> testMap(){
        //如果使用字符串返回就相当于调用
        User user = new User();
        user.setName("易烊千玺");
        user.setAge(20);
        user.setGender("男");
        user.setBirthday(new Date());
        user.setInfo("真帅");

        List<String> foods = new ArrayList<>();

        foods.add("羊肉串");
        foods.add("牛肉串");
        foods.add("猪肉串");
        foods.add("鸡肉串");

        Map<String, Object> map = new HashMap<>();

        map.put("code",20);
        map.put("success",true);
        map.put("message" ,"嘿嘿");
        map.put("data",user);
        map.put("foods",foods);
        return map;
    }
}
