package com.zhafei.ums.dao;

import com.zhafei.ums.entity.UmsSysUser;

public interface UmsSysUserDao {
    int deleteByPrimaryKey(Long id);

    int insert(UmsSysUser record);

    int insertSelective(UmsSysUser record);

    UmsSysUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsSysUser record);

    int updateByPrimaryKey(UmsSysUser record);
}