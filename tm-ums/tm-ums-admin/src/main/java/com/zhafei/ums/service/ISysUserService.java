package com.zhafei.ums.service;

import com.zhafei.ums.domain.entity.UmsSysUser;
import com.zhafei.ums.rest.vo.UmsSysUserVO;

import java.util.List;

/**
 * @author yyf
 * @version v1.0
 * @description 用户接口
 * @create 2021/4/4 0:43:41
 */
public interface ISysUserService {
    /**
     * 获取用户集合
     * @param vo
     * @return
     */
    public abstract List<UmsSysUser> selectSysUsers(UmsSysUserVO vo);

    /**
     * 根据uid查询用户
     * @param uid
     * @return
     */
    public abstract UmsSysUser findSysUser(String uid);

    /**
     * 根据uid更新用户信息
     * @param vo
     * @return
     */
    public abstract UmsSysUser modifySysUser(UmsSysUserVO vo);
}
