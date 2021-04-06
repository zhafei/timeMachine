package com.zhafei.ums.rest;

import com.zhafei.ums.rest.vo.UmsSysUserVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yyf
 * @version v1.0
 * @description 系统用户控制类
 * @create 2021/4/4 0:18:40
 */
@RestController
@RequestMapping("/user")
public class SysUserController {
    /**
     * 获得用户集合
     * @param vo
     * @return
     */
    @GetMapping("query")
    public ResponseEntity<List<UmsSysUserVO>> query(UmsSysUserVO vo){

        return null;
    }
    @GetMapping("{uid}")
    public ResponseEntity<UmsSysUserVO> get(@PathVariable String uid){
        return null;
    }


}
