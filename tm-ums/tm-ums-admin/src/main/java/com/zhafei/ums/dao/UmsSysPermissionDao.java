package com.zhafei.ums.dao;

import com.zhafei.ums.domain.entity.UmsSysPermission;

public interface UmsSysPermissionDao {
    int deleteByPrimaryKey(Long id);

    int insert(UmsSysPermission record);

    int insertSelective(UmsSysPermission record);

    UmsSysPermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsSysPermission record);

    int updateByPrimaryKey(UmsSysPermission record);
}