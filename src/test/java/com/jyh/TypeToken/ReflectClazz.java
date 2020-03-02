package com.jyh.TypeToken;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author jyh
 * @date 2019/11/29
 * @description
 */

public class ReflectClazz<V> {

    private Class<V> classType;

    public void doSth() {
        final Type genType = getClass().getGenericSuperclass();
        // 获得子类的泛型类型
        classType = (Class<V>) ((ParameterizedType) genType).getActualTypeArguments()[0];
    }

}
