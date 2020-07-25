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
        result.put("msg","正在判断您输入的电话号码:"+number+",是否重复");
        return result;
    }

    @RequestMapping("/empty/{number}")
    @ResponseBody
    public Object numberIsEmpty(@PathVariable String number){
        Map result = new HashMap();
        result.put("code","1");
        result.put("msg","正在判断您输入的电话号码:"+number+",是否为空");
        return result;
    }

    @RequestMapping("/delete/{number}")
    @ResponseBody
    public Object delete(@PathVariable String number){
        Map result = new HashMap();
        result.put("code","1");
        result.put("msg","正在删除您输入的电话号码:"+number);
        return result;
    }

    @RequestMapping("/remove/{number}")
    @ResponseBody
    public Object remove(@PathVariable String number){
        Map result = new HashMap();
        result.put("code","1");
        result.put("msg","正在移除您输入的电话号码:"+number);
        return result;
    }
}
