package com.lv.controller;

import com.lv.model.User;
import com.lv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lvsr
 * on 2018/07/1920:29
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    /*@Autowired
    private User user;*/
    @Autowired
    private UserService userService;

    //@RequestMapping(value = "/sayHello" ,method = RequestMethod.GET)
    @GetMapping("/say")
    public String hello(@RequestParam(value = "name",required = false,defaultValue = "lv") String myName){
       // return user.getName();
        return "my name is:" + myName;
    }

    @RequestMapping("/toLogin")
    public ModelAndView toLogin(){
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute User user) {
        String name = user.getUserName();
        String password = user.getUserPassword();

        if (name.equals("") && password.equals("tianle")) {
            return "Success";
        } else {
            return "Failed";
        }
    }

}
