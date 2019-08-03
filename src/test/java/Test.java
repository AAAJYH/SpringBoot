import java.util.ArrayList;
import java.util.List;

/**
 * @author: 姬雨航
 * @date: 2019/7/29 11:32
 * @description：
 */

public class Test {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        List list1 = new ArrayList();
        list1.add(1);
        list1.add(3);

        list.removeAll(list1);
        System.out.println(list.size());
    }

}
