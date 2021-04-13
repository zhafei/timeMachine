package com.zhafei.ums.domain;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author yyf
 * @version v1.0
 * @description 对象转换
 * @create 2021/4/7 11:31:53
 */
public class ObjectConverter {

    public static void toDto(Object entity, Object dto) {
        BeanUtils.copyProperties(entity, dto);
    }
    public static List<?> entity2dto(List<?> entityList,Class<?> clazz) {
        if (entityList == null) {
            return null;
        } else {
            List<Object> list = new ArrayList(entityList.size());
            Iterator var3 = entityList.iterator();
            while(var3.hasNext()) {
                Object e = (Object)var3.next();
                Object dto = null;
                try {
                    Constructor<?> constructor = clazz.getDeclaredConstructor();
                    constructor.setAccessible( true );
                    dto = (Object) constructor.newInstance();
                } catch (InstantiationException
                        | IllegalAccessException
                        | NoSuchMethodException
                        | InvocationTargetException exc) {
                    exc.printStackTrace();
                }
                BeanUtils.copyProperties(e, dto);
                list.add(dto);
            }

            return list;
        }
    }

}
