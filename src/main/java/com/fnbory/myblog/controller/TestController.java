package com.fnbory.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

@RequestMapping("/success")
    public  String succ(){
    return "success";
}

@RequestMapping("/hello")
@ResponseBody
    public  String hello(){
    return "hello";
}
}
