package com.zhafei.ums.dao;

import com.zhafei.ums.domain.entity.UmsSysRoleMenu;

public interface UmsSysRoleMenuDao {
    int deleteByPrimaryKey(Long id);

    int insert(UmsSysRoleMenu record);

    int insertSelective(UmsSysRoleMenu record);

    UmsSysRoleMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsSysRoleMenu record);

    int updateByPrimaryKey(UmsSysRoleMenu record);
}