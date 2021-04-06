package com.zhafei.ums.service.impl;

import com.zhafei.ums.entity.UmsSysMenu;
import com.zhafei.ums.service.ISysMenuService;
import com.zhafei.ums.util.SystemClock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ISysMenuServiceImplTest {
    @Autowired
    private ISysMenuService iSysMenuService;
    @Test
    public void selectSysMenus() {
    }

    @Test
    public void createSysMenu() {
        UmsSysMenu record = new UmsSysMenu();
        record.setParentId(0L);
        record.setName("系统管理");
        record.setUrl("#;");
        record.setPath("/");
        record.setCss("/");
        record.setSort(0);
        record.setCreateTime(SystemClock.nowDateTime());
        record.setUpdateTime(SystemClock.nowDateTime());
        record.setIsMenu(0);
        record.setHidden(0);

        iSysMenuService.createSysMenu(record);
    }
}