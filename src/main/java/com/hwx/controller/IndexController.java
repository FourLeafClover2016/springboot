package com.hwx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转控制器
 * @author: Huawei Xie
 * @date: 2019/4/1
 */
@Controller
public class IndexController {
    @RequestMapping(value = {"/", "/index"})
    public String index() {
        return "index";
    }

    @RequestMapping(value = {"/users"})
    public String users() {
        return "users";
    }
}
