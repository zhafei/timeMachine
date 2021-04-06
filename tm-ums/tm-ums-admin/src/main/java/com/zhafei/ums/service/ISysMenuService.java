package com.zhafei.ums.service;

import com.zhafei.ums.entity.UmsSysMenu;

import java.util.List;

/**
 * @author yyf
 * @version v1.0
 * @description 菜单接口
 * @create 2021/4/4 12:52:49
 */
public interface ISysMenuService {
    /**
     * 获得菜单集合
     * @param record
     * @return
     */
    public abstract List<UmsSysMenu> selectSysMenus(UmsSysMenu record);

    /**
     * 新增菜单
     * @param record
     * @return
     */
    public abstract UmsSysMenu createSysMenu(UmsSysMenu record);
}
