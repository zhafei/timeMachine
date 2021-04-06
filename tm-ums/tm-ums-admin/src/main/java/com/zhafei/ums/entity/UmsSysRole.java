package com.zhafei.ums.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * ums_sys_role
 * @author 
 */
public class UmsSysRole implements Serializable {
    private Long id;

    /**
     * 角色编码
     */
    private String code;

    /**
     * 角色名
     */
    private String name;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}