package Collection.Map.LinkedHashMap;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * LinkedHashMap常用方法
 */

public class LinkedHashMapMethod {

    /**
     * removeEldestEntry()：当集合put成功时，如果集合的size大于指定值（2），就remove最早的一个key和value
     *
     * eldest：长老；年事；年老；
     */
    @Test
    public void removeEldestEntry() {
        Map<String, String> map = new LinkedHashMap() {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > 2;
            }
        };
        map.put("name1", "hh");
        map.put("name2", "hh");
        map.put("name3", "hehe");
        map.forEach((k, v) -> System.out.println(k + " " + v));
    }

}
