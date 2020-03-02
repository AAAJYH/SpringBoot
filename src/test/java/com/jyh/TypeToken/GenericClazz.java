package com.jyh.TypeToken;

import com.google.common.reflect.TypeToken;

/**
 * @author jyh
 * @date 2019/11/29
 * @description
 */

public class GenericClazz<V> {

    private Class<V> classType;

    public void doSth() {
        final TypeToken<V> typeToken = new TypeToken<V>(getClass()) {};
        //获得子类的泛型类型
        classType = (Class<V>) typeToken.getRawType();
    }

}
