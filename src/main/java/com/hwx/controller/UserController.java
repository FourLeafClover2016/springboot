package com.hwx.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hwx.model.SysUser;
import com.hwx.service.SysUserService;
import com.hwx.utils.ResultMessge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户信息控制器
 *
 * @author: Huawei Xie
 * @date: 2019/4/19
 */
@RestController
public class UserController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 获取用户列表
     *
     * @param pageNum  页码
     * @param pageSize 每页数量
     * @return
     */
    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public IPage<SysUser> getUsers(int pageNum, int pageSize) {
        return sysUserService.getUsers(pageNum, pageSize);
    }

    /**
     * 新增用户
     *
     * @param user 用户信息封装对象
     * @return
     */
    @PostMapping("/add")
    public ResultMessge addUser(@RequestBody SysUser user) {
        return sysUserService.saveUser(user);
    }

    /**
     * 根据用户id删除用户
     *
     * @param id 用户id
     * @return
     */
    @GetMapping("/del")
    public ResultMessge delUser(@RequestParam Integer id) {
        return sysUserService.delUser(id);
    }
}
