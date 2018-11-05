package com.lv.util;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by simperLv
 * on 2018/10/18 10:03
 *
 * @Description //TODO
 */
public final class LoggerUtils {
    public static final String LOGGER_RETURN = "_logger_return";

    private LoggerUtils(){}

    public static String getClientIp(HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.trim() == "" || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.trim() == "" || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.trim() == "" || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        //多个路由时，取第一个unknown的ip
        final String[] arr = ip.split(",");
        for (final String str : arr){
            if (!"unknown".equalsIgnoreCase(str)){
                ip = str;
                break;
            }
        }
        return ip;
    }
    public static String getRequestType(HttpServletRequest request){
        return request.getHeader("X-Requested-With");
    }
}
