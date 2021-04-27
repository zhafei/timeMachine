package com.zhafei.pay.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * @author yyf
 * @version v1.0
 * @description 基础实体类
 * @create 2021/4/26 18:37:49
 */
//解决：在实体类中 发现有字段为null，在转化成json的时候，fasterxml.jackson将对象转换为json报错
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class BaseModel<T extends BaseModel> implements Serializable {
    private static final long serialVersionUID = 1L;
}
