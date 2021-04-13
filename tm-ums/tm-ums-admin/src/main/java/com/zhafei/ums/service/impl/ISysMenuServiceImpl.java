package com.zhafei.ums.service.impl;

import com.zhafei.common.util.SnowflakeIdWorker;
import com.zhafei.ums.dao.UmsSysMenuDao;
import com.zhafei.ums.domain.ObjectConverter;
import com.zhafei.ums.domain.dto.MenuDto;
import com.zhafei.ums.domain.entity.UmsSysMenu;
import com.zhafei.ums.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author yyf
 * @version v1.0
 * @description
 * @create 2021/4/4 12:57:17
 */
@Service
public class ISysMenuServiceImpl implements ISysMenuService {
    @Autowired
    private UmsSysMenuDao umsSysMenuDao;
    @Override
    public List<UmsSysMenu> selectSysMenus(UmsSysMenu record) {
        return umsSysMenuDao.selectList(null);
    }
    @Override
    public List<MenuDto> selectMenus(UmsSysMenu record) {
        return (List<MenuDto>) ObjectConverter.entity2dto(umsSysMenuDao.selectList(record),MenuDto.class);
    }

    @Override
    public UmsSysMenu createSysMenu(UmsSysMenu record) {
        record.setId(new SnowflakeIdWorker(0, 0).nextId());
        umsSysMenuDao.insertSelective(record);
        return record;
    }
    /**
     * 获取集合中所有的根节点
     *
     * @param umsSysMenuList
     * @return
     */
    public List<UmsSysMenu> getRootNodes(List<UmsSysMenu> umsSysMenuList) {
        List<UmsSysMenu> rootNodes = new ArrayList<>();
        for (UmsSysMenu sysMenu : umsSysMenuList) {
            if (rootNode(sysMenu,umsSysMenuList)) {
                rootNodes.add(sysMenu);
            }
        }
        return rootNodes;
    }

    /**
     * 判断是否为跟节点
     * @param umsSysMenu
     * @param umsSysMenuList
     * @return 是true,否false
     */
    public boolean rootNode(UmsSysMenu umsSysMenu,List<UmsSysMenu> umsSysMenuList){
        for (UmsSysMenu sysMenu : umsSysMenuList) {
            if(!umsSysMenu.getParentId().equals(sysMenu.getId())) {
               return true;
            }
        }
        return false;
    }
    @Override
    public List<MenuDto> buildMenuTree(List<MenuDto> menuDtoList) {
        List<MenuDto> trees = new ArrayList<>();
        Set<Long> ids = new HashSet<>();
        for (MenuDto menuDto : menuDtoList) {
            if (menuDto.getParentId() == null) {
                trees.add(menuDto);
            }
            for (MenuDto it : menuDtoList) {
                if (menuDto.getId().equals(it.getParentId())) {
                    if (menuDto.getChildren() == null) {
                        menuDto.setChildren(new ArrayList<>());
                    }
                    menuDto.getChildren().add(it);
                    ids.add(it.getId());
                }
            }
        }
        if(trees.size() == 0){
            trees = menuDtoList.stream().filter(s -> !ids.contains(s.getId())).collect(Collectors.toList());
        }
        return trees;
    }
}
