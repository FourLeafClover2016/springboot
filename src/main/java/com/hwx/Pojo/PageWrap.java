package com.hwx.Pojo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @author: Huawei Xie
 * @date: 2019/5/1
 */
public class PageWrap extends Page {
    private int code = 0;

    public PageWrap(long current, long size) {
        super(current, size);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
