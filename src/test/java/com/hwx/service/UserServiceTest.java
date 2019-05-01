package com.hwx.service;

import com.hwx.Application;
import com.hwx.model.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户Service层测试类
 * @author: Huawei Xie
 * @date: 2019/5/1
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserServiceTest {
    @Autowired
    private SysUserService userService;

    @Test
    public void update(){
        SysUser user = new SysUser();
        user.setUsername("admin1");
        user.setPasswd("admin");
        user.setRoleId(1);
        System.out.println(userService.update(user));
    }

    @Test
    public void updateById(){
        SysUser user = new SysUser();
        user.setId(2);
       // user.setUsername("admin1");
        user.setPasswd("admin33");
        user.setRoleId(1);
        System.out.println(userService.updateById(user));
    }

    @Test
    public void select(){
        //System.out.println(userService.selectById(1));
        Map<String, Object> map = new HashMap<>();
        map.put("role_id",1);
        System.out.println(userService.selectByMap(map));

        System.out.println(userService.selectOne("admin"));
        System.out.println(userService.selectCount());
        System.out.println(userService.selectList());
        System.out.println(userService.selectMaps());
    }

    @Test
    public void selectBatchId(){
        List<Integer> idList = new ArrayList<>();
        idList.add(1);
        idList.add(2);
        System.out.println(userService.selectBatchIds(idList));
    }
}
