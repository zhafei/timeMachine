package com.zhafei.ums.rest.vo;

/**
 * @author yyf
 * @version v1.0
 * @description 用户vo
 * @create 2021/4/4 0:22:36
 */
public class UmsSysUserVO {
    private String id;
    private String uid;
    private String nickName;
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
