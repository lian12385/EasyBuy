package com.buliang.util;

import com.buliang.pojo.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import sun.rmi.log.LogInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtil {
    private static String USER_IN_SESSION = "loginUser";

    public static HttpSession getSession(){
        return ((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes())).getRequest().getSession();
    }

    public static void setUserInSession(User loginUser){
        getSession().setAttribute(USER_IN_SESSION,loginUser);
    }

    public static User getCurrentUser(){
        return (User) getSession().getAttribute(USER_IN_SESSION);
    }

    public static void invalidSession(){
        getSession().invalidate();
    }
}
