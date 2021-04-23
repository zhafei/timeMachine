package com.zhafei.ums.dao;

import com.zhafei.ums.domain.entity.UmsSysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UmsSysUserDao {
    int deleteByPrimaryKey(Long id);

    int insert(UmsSysUser record);

    int insertSelective(UmsSysUser record);

    UmsSysUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsSysUser record);

    int updateByPrimaryKey(UmsSysUser record);
}