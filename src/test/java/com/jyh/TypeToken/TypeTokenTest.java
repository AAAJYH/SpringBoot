package com.jyh.TypeToken;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.reflect.TypeToken;

import java.util.List;
import java.util.Map;

/**
 * @author jyh
 * @date 2019/11/29
 * @description
 */

public class TypeTokenTest {

    public static void main(String[] args) {
        String str = "{\"1\":{\"name\":\"name0\",\"age\":0}, \"2\":{\"name\":\"name1\",\"age\":1}}";
        System.out.println(str);
        Map<String, Student> studentMap = JSONObject.parseObject(str, new TypeToken<Map<String, Student>>(){}.getType());
        System.out.println(studentMap);

        List studentMap1 = JSON.parseArray(str);

        System.out.println(new TypeToken<Map<String, Student>>(){}.getType());

        System.out.println(new TypeToken<Map<String, Student>>(){}.getType().getTypeName());

        System.out.println(new Student().toString());
    }

}
