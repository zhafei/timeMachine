package com.zhafei.ums.dao;

import com.zhafei.ums.domain.entity.UmsSysMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UmsSysMenuDao {
    int deleteByPrimaryKey(Long id);

    int insert(UmsSysMenu record);

    int insertSelective(UmsSysMenu record);

    List<UmsSysMenu> selectList(UmsSysMenu record);

    UmsSysMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsSysMenu record);

    int updateByPrimaryKey(UmsSysMenu record);
}