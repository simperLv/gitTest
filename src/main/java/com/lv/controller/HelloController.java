package com.lv.controller;

import com.lv.model.User;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lvsr
 * on 2018/07/1920:29
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return"index";
    }

    @RequestMapping("/toLogin")
    public ModelAndView toLogin(){
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute User user) {
        String name = user.getName();
        String password = user.getPassWord();

        if (name.equals("qinya") && password.equals("tianle")) {
            return "Success";
        } else {
            return "Failed";
        }
    }

}
