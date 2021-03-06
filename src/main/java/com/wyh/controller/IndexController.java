package com.wyh.controller;

import com.wyh.annotation.FreeAccess;
import com.wyh.annotation.LoginRequired;
import com.wyh.annotation.PrivilegeRequired;
import com.wyh.common.SessionBean;
import com.wyh.constant.Constants;
import com.wyh.dao.TestMapper;
import com.wyh.entity.User;
import com.wyh.service.solr.CoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import privilege.PrivilegeBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Created by root on 2016/12/20.
 */

@Controller
@RequestMapping("/index")
public class IndexController {
    private final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    TestMapper testMapper;

    @Autowired
    CoreService coreService;

    @FreeAccess
    @RequestMapping("/index")
    public String index(HttpServletRequest httpServletRequest, HttpServletResponse response, ModelMap modelMap) {
        modelMap.addAttribute("name", "name");
        SessionBean sessionBean = new SessionBean();
        sessionBean.setUser(new User());
        Set<PrivilegeBean> set = new HashSet<>();
        set.add(PrivilegeBean.USER_ADD);
        sessionBean.setPrivileges(set);
        httpServletRequest.getSession().setAttribute(Constants.SESSION_BEAN, sessionBean);
        if(httpServletRequest.getSession().getAttribute(Constants.REDIRECT_URL) != null) {
            try {
                System.out.println(httpServletRequest.getSession().getAttribute(Constants.REDIRECT_URL));
                response.sendRedirect(httpServletRequest.getSession().getAttribute(Constants.REDIRECT_URL).toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        coreService.test();
        return "index";
    }

    @FreeAccess
    @RequestMapping(value = "test", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List test() {
        List list  = new ArrayList<>();
        list.add("s");
        return list;
    }

    @LoginRequired
    @RequestMapping("/testLogin")
    public String testLogin(HttpServletRequest httpServletRequest, ModelMap modelMap) {
        modelMap.addAttribute("login", "login");
        return "index";
    }

    @LoginRequired
    @PrivilegeRequired(privileges = {PrivilegeBean.USER_ADD})
    @RequestMapping("/testPre")
    public String testPre(HttpServletRequest httpServletRequest, ModelMap modelMap) {
        modelMap.addAttribute("login", "login");
        return "index";
    }
}
