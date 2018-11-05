package com.lv.controller;

import com.lv.model.User;
import com.lv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    public ModelAndView login(User user, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
       //登录成功
        boolean flag = true;
        String result = "登录成功";
        User userRes  = userService.findOne(user);
        //用户不存在
        if (userRes == null){
            flag = false;
            result = "用户名不存在，登录失败";
        }
        //登录成功
        if (flag){
            //将用户存入session
            request.getSession().setAttribute("sessionUser",user);
        }
        modelAndView.addObject("result",result);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<User> list(){
        User user = null;
        return userService.findUser(user);
    }

    @RequestMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("index");
    }
}
