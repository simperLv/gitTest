package com.lv.controller;

import com.lv.model.User;
import com.lv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by simperLv
 * on 2018/08/13 16:49
 *
 * @Description //TODO
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public int addUser(User user){
        return userService.addUser(user);
    }

    @PostMapping("/login")
    public String login(String name,String passWord){
       return "";
    }
}
