package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("date")
public class DateController {
    @RequestMapping("getString")
    public void getString(String date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parse=null;
        try {
            parse = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("字符串"+date);
        System.out.println("欸嘿:"+parse);
    }
    @RequestMapping("getDate")
    public void getDate(Date date){
        System.out.println("date"+date);
    }
}
