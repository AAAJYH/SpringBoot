package com.jyh.泛型;

import java.util.Map;

/**
 * @author jyh
 * @date 2019/12/13
 * @description
 */

/**
 * 1. 泛型为什不能是int, float
 * 泛型类型是对象类型，而基本类型不属于对象类型，所以要用基本类型的包装类型
 */

/**
 * 泛型标识
 * E-Element：集合中使用
 * T-Type: java类
 * N-Number: 数值类型
 * K-Key: 键
 * V-Value: 值
 * ? : 表示不确定的类型
 */

public interface Father<T> {

    T a();

}
