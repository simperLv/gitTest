package com.lv;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by simperLv
 * on 2018/10/24 14:18
 *
 * @Description 使用拦截器记录你的SpringBoot的请求日志
 */
@Configuration
public class LoggerConfguration implements WebMvcConfigurer {
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new LoggerInterceptor()).addPathPatterns("/**");
    }
}
