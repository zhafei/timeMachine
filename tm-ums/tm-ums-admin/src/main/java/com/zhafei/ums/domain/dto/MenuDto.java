package com.zhafei.ums.domain.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author yyf
 * @version v1.0
 * @description 菜单传输对象
 * @create 2021/4/7 9:20:37
 */
public class MenuDto implements Serializable {
    private Long id;

    private Long parentId;

    private String name;

    private String url;

    private String path;

    private String css;

    private Integer sort;
    /**
     * 是否菜单 1 是 2 不是
     */
    private Integer isMenu;

    /**
     * 是否隐藏,0 false 1 true
     */
    private Integer hidden;
    /**
     * 子节点
     */
    private List<MenuDto> children;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getCss() {
        return css;
    }

    public void setCss(String css) {
        this.css = css;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getIsMenu() {
        return isMenu;
    }

    public void setIsMenu(Integer isMenu) {
        this.isMenu = isMenu;
    }

    public Integer getHidden() {
        return hidden;
    }

    public void setHidden(Integer hidden) {
        this.hidden = hidden;
    }

    public List<MenuDto> getChildren() {
        return children;
    }

    public void setChildren(List<MenuDto> children) {
        this.children = children;
    }
}
