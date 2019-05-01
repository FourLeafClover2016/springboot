package com.hwx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hwx.model.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 *
 * @author hwx
 * @since 2019-04-30
 */
@Mapper
@Component
public interface SysRoleMapper extends BaseMapper<SysRole> {

}
