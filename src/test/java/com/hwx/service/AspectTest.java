package com.hwx.service;

import com.hwx.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * AOP测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class AspectTest {
    @Autowired
    SysUserService sysUserService;
    @Test
    public void beforeTest(){
       // System.out.println(sysUserService.selectList());
        System.out.println(sysUserService.selectOne("admin"));
    }
}
