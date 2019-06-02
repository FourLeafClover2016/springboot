package com.hwx.dao;

import com.hwx.model.LockedUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Mapper
public interface LockedUserMapper {

    int insert(LockedUser record);

    int deleteByUsername(@Param("userName") String userName);

    int selectCount(@Param("userName") String userName, @Param("date") Date date);

}