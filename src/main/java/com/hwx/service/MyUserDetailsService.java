package com.hwx.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hwx.dao.SysRoleMapper;
import com.hwx.dao.SysUserMapper;
import com.hwx.model.SysRole;
import com.hwx.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Huawei Xie
 * @date: 2019/4/1
 */
@Component
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUserBean = new SysUser();
        sysUserBean.setUsername(username);

        SysUser sysUser = sysUserMapper.selectOne(new QueryWrapper<SysUser>().eq("username", username));

        if (null == sysUser) {
            throw new UsernameNotFoundException("未知用户:" + username);
        }

        SysRole role = sysRoleMapper.selectById(sysUser.getRoleId());
        List<GrantedAuthority> authorities = new ArrayList<>();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRoleName());
        authorities.add(grantedAuthority);

        UserDetails user = new User(sysUser.getUsername(), sysUser.getPasswd(), authorities);
        return user;
    }


}
