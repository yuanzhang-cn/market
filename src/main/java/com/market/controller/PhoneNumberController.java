package com.market.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/phone")
public class PhoneNumberController {

    @RequestMapping("/index")
    @ResponseBody
    public Object index(){
        Map result = new HashMap();
        result.put("code","1");
        result.put("msg","欢迎进入market");
        return result;
    }

    @RequestMapping("/repeat/{number}")
    @ResponseBody
    public Object numberIsRepeat(@PathVariable String number){
        Map result = new HashMap();
        result.put("code","1");
        result.put("msg","您输入的电话号码是:"+number);
        return result;
    }

    @RequestMapping("/empty/{number}")
    @ResponseBody
    public Object numberIsEmpty(@PathVariable String number){
        Map result = new HashMap();
        result.put("code","1");
        result.put("msg","您输入的电话号码是:"+number);
        return result;
    }
}
