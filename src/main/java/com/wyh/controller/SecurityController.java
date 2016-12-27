package com.wyh.controller;

import com.wyh.annotation.FreeAccess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 2016/12/27.
 */

@FreeAccess
@Controller
@RequestMapping("/se")
public class SecurityController {
    private final Logger logger = LoggerFactory.getLogger(SecurityController.class);

    @RequestMapping("/index")
    @ResponseBody
    public List<String> index(){
        List<String> list = new ArrayList<>();
        list.add("list1");
        list.add("list2");
        list.add("list3");
        return list;
    }

}
