package com.zhafei.ums.dao;

import com.zhafei.ums.entity.UmsSysRoleUser;

public interface UmsSysRoleUserDao {
    int deleteByPrimaryKey(Long id);

    int insert(UmsSysRoleUser record);

    int insertSelective(UmsSysRoleUser record);

    UmsSysRoleUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsSysRoleUser record);

    int updateByPrimaryKey(UmsSysRoleUser record);
}