package com.wyh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by root on 2016/12/20.
 */

@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("/index")
    public String index(HttpServletRequest httpServletRequest, ModelMap modelMap) {
        modelMap.addAttribute("name", "name");
        System.out.println("name");
        return "index";
    }
}
