import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: jyh
 * @Date: 2019/4/8 10:22
 */
public final class a {

    public String bbb = "fdsf";

    public static String aaa = "123";

    public List<Map<String,String>> list = new ArrayList<Map<String,String>>();

    public Map<String,String> maps = new HashMap<String,String>();

    public a(){
        Map<String, String> map = new HashMap<String,String>();
        map.put("主卡","123");
        map.put("副卡", "321");
        list.add(map);
        maps.put("主卡", "123");
        maps.put("副卡", "321");
    }

    public void c () {
        System.out.println("shiro");
    }

}
