package com.hwx.utils;

import com.hwx.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: Huawei Xie
 * @date: 2019/5/6
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ListPropertiesTest {

    @Autowired
    private ListProperties listProperties;

    @Test
    public void getIpLists(){
        System.out.println(listProperties.getList());
        System.out.println(listProperties.getApple());
        System.out.println(listProperties.getPeople());
        System.out.println(listProperties.getStudent());
        System.out.println(listProperties.getSet());
    }
}
