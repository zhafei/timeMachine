package com.zhafei.ums.dao;

import com.zhafei.ums.entity.UmsSysRole;

public interface UmsSysRoleDao {
    int deleteByPrimaryKey(Long id);

    int insert(UmsSysRole record);

    int insertSelective(UmsSysRole record);

    UmsSysRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsSysRole record);

    int updateByPrimaryKey(UmsSysRole record);
}