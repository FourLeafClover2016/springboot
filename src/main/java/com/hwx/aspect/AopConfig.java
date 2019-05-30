package com.hwx.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * AOP切面配置
 */
@Aspect
@Component
public class AopConfig {

    /*@Pointcut("execution(* com.hwx.dao.*.*(..))")
    public void aspectDao() {

    }*/

    @Before("execution(* com.hwx.service.*.*(..)))")
    public void aspectBefore(JoinPoint joinPoint) {
        System.out.println("-----------------------");
        System.out.println("@Before：参数为：" + Arrays.toString(joinPoint.getArgs()));
    }

}
