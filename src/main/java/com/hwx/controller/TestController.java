package com.hwx.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Huawei Xie
 * @date: 2019/8/14
 */
@RestController
public class TestController {
    @GetMapping("/test")
    public String test() {
        int i = 5 / 0;
        return "测试成功";
    }
}
