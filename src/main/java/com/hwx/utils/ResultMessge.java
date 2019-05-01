package com.hwx.utils;

/**
 * 返回信息包装类
 *
 * @author: Huawei Xie
 * @date: 2019/5/1
 */
public class ResultMessge {
    /**
     * 状态码
     */
    private int code = 0;

    /**
     * 是否请求成功
     */
    private boolean sucess = true;

    /**
     * 返回携带信息
     */
    private Object result;

    public ResultMessge() {
    }

    public void initErrorMessage() {
        this.code = 1;
        this.sucess = false;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSucess() {
        return sucess;
    }

    public void setSucess(boolean sucess) {
        this.sucess = sucess;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResultMessge{" +
                "code=" + code +
                ", sucess=" + sucess +
                ", result=" + result +
                '}';
    }
}
