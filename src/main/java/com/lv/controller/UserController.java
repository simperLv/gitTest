package com.lv.controller;

import com.lv.model.User;
import com.lv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

/**
 * Created by simperLv
 * on 2018/08/13 16:49
 *
 * @Description 使用SpringBoot validator对数据进行验证
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private MessageSource messageSource; //用于格式化错误消息

    @PostMapping("/add")
    public int addUser(User user){
        return userService.addUser(user);
    }

    /**
     * 登录方法
     * @param user
     * @param request
     * @return
     */
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
            modelAndView.setViewName("index");
        }else{
            modelAndView.setViewName("login");
        }
        modelAndView.addObject("result",result);
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

    @RequestMapping("/validator")
    public String validator(@Valid User user, BindingResult result){
        if (result.hasErrors()){
            StringBuffer msg = new StringBuffer();
            //获取错误字段集合
            List<FieldError> fieldErrors = result.getFieldErrors();
            //获取本地locale，zh_cn，
            // hibernate-validator的错误消息支持国际化，所以我们获取错误消息的时候需要传入Locale对象获取本地的国际化类型。
            Locale currentLocale = LocaleContextHolder.getLocale();
            //遍历错误字段获取错误消息
            for (FieldError fieldError : fieldErrors) {
                //获取错误信息
                String errorMessage = messageSource.getMessage(fieldError,currentLocale);
                //添加到错误消息集合内
                msg.append(fieldError.getField()+"："+errorMessage+" , ");
            }
            return msg.toString();
        }
        return "验证通过" + "用户名:" + user.getUserName() + "密码：" + user.getUserPassword() + "邮箱：" + user.getEmail();
    }
}
