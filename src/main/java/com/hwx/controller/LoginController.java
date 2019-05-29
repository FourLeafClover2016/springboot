package com.hwx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * @author: Huawei Xie
 * @date: 2019/4/1
 */
@Controller
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, HttpSession session) {
        if (null != session.getAttribute("message")) {
            model.addAttribute("msg", session.getAttribute("message"));
            session.removeAttribute("message");
        }
        return "login";
    }
}
