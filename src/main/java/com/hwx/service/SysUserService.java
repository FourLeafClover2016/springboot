package com.hwx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hwx.model.SysUser;
import com.hwx.utils.ResultMessge;

import java.util.List;
import java.util.Map;


/**
 * @author: Huawei Xie
 * @date: 2019/4/19
 */
public interface SysUserService {

    /**
     * 获取所用用户信息
     *
     * @param pageNum  页码
     * @param pageSize 每页数量
     * @return
     */
    IPage<SysUser> getUsers(int pageNum, int pageSize);

    /**
     * 新增用户信息
     *
     * @param user 用户信息封装对象
     * @return
     */
    ResultMessge saveUser(SysUser user);

    /**
     * 删除用户
     *
     * @param id 用户id
     * @return
     */
    ResultMessge delUser(Integer id);

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    ResultMessge update(SysUser user);

    /**
     * 通过Id更新用户信息
     *
     * @param user 用户信息封装对象
     * @return
     */
    ResultMessge updateById(SysUser user);

    /**
     * 通过id查询用户信息
     *
     * @param id
     * @return
     */
    ResultMessge selectById(int id);

    /**
     * 通过id列表批量查询
     *
     * @param idList
     * @return
     */
    ResultMessge selectBatchIds(List<Integer> idList);

    /**
     * 通过条件查询用户信息
     *
     * @param columnMap 查询条件 key 字段名，value 字段值
     * @return
     */
    ResultMessge selectByMap(Map<String, Object> columnMap);

    /**
     * 通过条件查询用户信息
     *
     * @param userName 查询条件
     * @return
     */
    ResultMessge selectOne(String userName);

    /**
     * 查询用户信息条数
     *
     * @return
     */
    ResultMessge selectCount();

    /**
     * selectList 查询接口
     *
     * @return
     */
    ResultMessge selectList();

    /**
     *  selectMaps 查询接口
     * @return
     */
    ResultMessge selectMaps();
}
