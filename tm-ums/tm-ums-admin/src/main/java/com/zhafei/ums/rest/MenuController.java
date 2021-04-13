package com.zhafei.ums.rest;

import com.zhafei.ums.domain.dto.MenuDto;
import com.zhafei.ums.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yyf
 * @version v1.0
 * @description 菜单控制类
 * @create 2021/4/7 9:48:18
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private ISysMenuService iSysMenuService;
    @GetMapping("/query")
    public ResponseEntity<Object> get(){
        List<MenuDto> menuDtoList = iSysMenuService.buildMenuTree(iSysMenuService.selectMenus(null));
        return ResponseEntity.ok(menuDtoList);
    }
}
