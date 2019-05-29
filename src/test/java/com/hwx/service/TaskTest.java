package com.hwx.service;

import com.hwx.Application;
import com.hwx.Pojo.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.atomic.AtomicInteger;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TaskTest {
    @Autowired
    Task task;
    @Test
    public void test(){
        System.out.println(task.getStr());
    }

    @Test
    public void test2(){
        AtomicInteger ai = new AtomicInteger(0);
        System.out.println(ai.compareAndSet(0,2));
        System.out.println(ai);
    }
}
