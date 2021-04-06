package com.zhafei.ums.service.impl;

import com.zhafei.ums.dao.UmsSysMenuDao;
import com.zhafei.ums.entity.UmsSysMenu;
import com.zhafei.ums.service.ISysMenuService;
import com.zhafei.ums.util.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public UmsSysMenu createSysMenu(UmsSysMenu record) {
        record.setId(new SnowflakeIdWorker(0, 0).nextId());
        umsSysMenuDao.insertSelective(record);
        return record;
    }
}
