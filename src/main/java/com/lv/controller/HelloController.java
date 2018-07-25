package com.lv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lvsr
 * on 2018/07/1920:29
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return"index";
    }
}
