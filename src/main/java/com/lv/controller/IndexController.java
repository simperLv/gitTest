package com.lv.controller;

import com.alibaba.fastjson.JSONObject;
import com.lv.util.LoggerUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by simperLv
 * on 2018/10/24 14:02
 *
 * @Description //TODO
 */
@RestController
@RequestMapping("/log")
public class IndexController {

    /**
     * 测试请求日志记录
     * @param request
     * @param name
     * @return
     * @throws Exception
     */
    @GetMapping("/login")
    public JSONObject login(HttpServletRequest request,String name) throws Exception{
        JSONObject obj = new JSONObject();
        obj.put("msg","用户:" + name + "登录成功。");
        //将返回值写入到请求对象中
        request.setAttribute(LoggerUtils.LOGGER_RETURN,obj);
        return obj;
    }
}
