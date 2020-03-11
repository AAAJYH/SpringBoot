package Collection.Map;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 几个Map都有的方法
 */

public class MapMethod {

    /**
     * computeIfAbsent()：如果指定的键尚未存在或值为Null，才能put成功
     */
    @Test
    public void computeIfAbsent() {
        Map<String, List<String>> map = new HashMap<>();
        map.computeIfAbsent("name", k -> new ArrayList<>()).add("张三");
        map.computeIfAbsent("name", k -> new ArrayList<>()).add("李四");
        System.out.println("集合");
        map.forEach((k, v) -> System.out.println(k + " " + v));

        System.out.println("-------------------------");

        Map<String, String> stringMap = new HashMap<>();
        stringMap.computeIfAbsent("name", k -> "张三");
        stringMap.computeIfAbsent("name", k -> "李四");
        System.out.println("对象");
        stringMap.forEach((k, v) -> System.out.println(k + " " + v));

    }

}
