package com.hwx.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 *
 * @author: Huawei Xie
 * @date: 2019/8/14
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    /**
     *  可定义各种异常，@ExceptionHandler(RuntimeException.class)
     * @param e
     * @return
     */

    @ExceptionHandler(Exception.class)
    public String myEcectionHandler(Exception e) {
        return "发生了异常，请及时处理";
    }

}
