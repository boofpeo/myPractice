package com.zhangyu.three.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/index")
public class IndexJspController {


    @RequestMapping(value = "/indexJsp")
    public String index(){
        return "index";
    }
}
