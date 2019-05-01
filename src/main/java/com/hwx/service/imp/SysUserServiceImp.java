package com.hwx.service.imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hwx.Pojo.PageWrap;
import com.hwx.dao.SysUserMapper;
import com.hwx.model.SysUser;
import com.hwx.service.SysUserService;
import com.hwx.utils.ResultMessge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: Huawei Xie
 * @date: 2019/4/19
 */
@Service
public class SysUserServiceImp implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public IPage<SysUser> getUsers(int pageNum, int pageSize) {
        Page<SysUser> page = new PageWrap(pageNum, pageSize);

        IPage<SysUser> sysUserIPage = sysUserMapper.selectPage(page, null);
        return sysUserIPage;
    }

    @Override
    public ResultMessge saveUser(SysUser user) {
        ResultMessge resultMessge = new ResultMessge();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPasswd(passwordEncoder.encode(user.getPasswd()));
        user.setCreateTime(new Date());
        user.setRoleId(1);
        try {
            sysUserMapper.insert(user);
            resultMessge.setResult("保存成功");
        } catch (Exception e) {
            resultMessge.initErrorMessage();
            resultMessge.setResult("保存失败");
        }
        return resultMessge;
    }

    @Override
    public ResultMessge delUser(Integer id) {
        ResultMessge resultMessge = new ResultMessge();
        try {
            // 方案1
            // sysUserMapper.deleteById(id);
            // 方案2
            /*Map<String,Object> columnMap = new HashMap<>();
            columnMap.put("id",id);
            sysUserMapper.deleteByMap(columnMap);*/
            // 方案3
            /*QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
            queryWrapper
                    .isNull("name")
                    .ge("age", 12)
                    .isNotNull("email");*/
            sysUserMapper.delete(new QueryWrapper<SysUser>().eq("id", id));
            resultMessge.setResult("删除成功");
        } catch (Exception e) {
            resultMessge.initErrorMessage();
            resultMessge.setResult("删除失败");
        }
        return resultMessge;
    }

    @Override
    public ResultMessge update(SysUser user) {
        ResultMessge resultMessge = new ResultMessge();
        UpdateWrapper<SysUser> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.set("passwd",3).eq("username", user.getUsername());
        try {
            sysUserMapper.update(user, userUpdateWrapper);
            resultMessge.setResult("更新成功");
        } catch (Exception e) {
            resultMessge.initErrorMessage();
        }
        return resultMessge;
    }

    @Override
    public ResultMessge updateById(SysUser user) {
        ResultMessge resultMessge = new ResultMessge();
        try {
            sysUserMapper.updateById(user);
            resultMessge.setResult("更新成功");
        } catch (Exception e) {
            resultMessge.initErrorMessage();
        }
        return resultMessge;
    }

    @Override
    public ResultMessge selectById(int id) {
        ResultMessge resultMessge = new ResultMessge();
        try {
            resultMessge.setResult(sysUserMapper.selectById(id));
        } catch (Exception e) {
            resultMessge.initErrorMessage();
        }
        return resultMessge;
    }

    @Override
    public ResultMessge selectBatchIds(List<Integer> idList) {
        ResultMessge resultMessge = new ResultMessge();
        try {
            resultMessge.setResult(sysUserMapper.selectBatchIds(idList));
        } catch (Exception e) {
            resultMessge.initErrorMessage();
        }
        return resultMessge;
    }

    @Override
    public ResultMessge selectByMap(Map<String, Object> columnMap) {
        ResultMessge resultMessge = new ResultMessge();
        try {
            resultMessge.setResult(sysUserMapper.selectByMap(columnMap));
        } catch (Exception e) {
            resultMessge.initErrorMessage();
        }
        return resultMessge;
    }

    @Override
    public ResultMessge selectOne(String userName) {
        ResultMessge resultMessge = new ResultMessge();
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userName);
        try {
            resultMessge.setResult(sysUserMapper.selectOne(queryWrapper));
        } catch (Exception e) {
            resultMessge.initErrorMessage();
        }
        return resultMessge;
    }

    @Override
    public ResultMessge selectCount() {
        ResultMessge resultMessge = new ResultMessge();
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", "admin");
        try {
            resultMessge.setResult(sysUserMapper.selectCount(null));
            //resultMessge.setResult(sysUserMapper.selectCount(queryWrapper));
        } catch (Exception e) {
            resultMessge.initErrorMessage();
        }
        return resultMessge;
    }

    @Override
    public ResultMessge selectList() {
        ResultMessge resultMessge = new ResultMessge();
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("username");
        try {
            resultMessge.setResult(sysUserMapper.selectList(null));
        } catch (Exception e) {
            resultMessge.initErrorMessage();
        }
        return resultMessge;
    }

    @Override
    public ResultMessge selectMaps() {
        ResultMessge resultMessge = new ResultMessge();
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", "admin3");
        try {
            List<Map<String, Object>> maps = sysUserMapper.selectMaps(queryWrapper);
            resultMessge.setResult(maps);
        } catch (Exception e) {
            resultMessge.initErrorMessage();
        }
        return resultMessge;
    }
}
