package com.wyh.web;

import com.wyh.annotation.FreeAccess;
import com.wyh.annotation.LoginRequired;
import com.wyh.annotation.PrivilegeRequired;
import com.wyh.common.SessionBean;
import com.wyh.constant.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import privilege.PrivilegeBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by root on 2016/12/23.
 */
public class AuthorizateInterceptor extends HandlerInterceptorAdapter {
    public final Logger logger = LoggerFactory.getLogger(AuthorizateInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("begin interceptor");
        if (!handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        SessionBean sb = (SessionBean) request.getSession().getAttribute(Constants.SESSION_BEAN);
        PrivilegeBean[] privileges = {};
        if (handlerMethod.getMethod().isAnnotationPresent(FreeAccess.class)
                || handlerMethod.getBean().getClass().isAnnotationPresent(FreeAccess.class)) {
            return true;
        }
        if (handlerMethod.getMethod().isAnnotationPresent(LoginRequired.class)
                || handlerMethod.getBean().getClass().isAnnotationPresent(LoginRequired.class)) {
            if (sb == null) {
                request.getSession().setAttribute(Constants.REDIRECT_URL, request.getRequestURL());
                response.sendRedirect("index");

            } else {
                logger.info("{}", sb);
            }
        }
        //对接口的访问权限过滤
        if (handlerMethod.getMethod().isAnnotationPresent(PrivilegeRequired.class)) {
            privileges = handlerMethod.getMethod().getAnnotation(PrivilegeRequired.class).privileges();
        } else if (handlerMethod.getBean().getClass().isAnnotationPresent(PrivilegeRequired.class)) {
            privileges = handlerMethod.getBean().getClass().getAnnotation(PrivilegeRequired.class).privileges();
        }
        for (PrivilegeBean p : privileges) {
            if (!sb.getPrivileges().contains(p)) {
                return false;
            }
        }
        logger.info("login {}", sb);
        return true;
    }

}
