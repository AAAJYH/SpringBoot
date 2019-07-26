import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class RedisTest{
    public static void main(String[] args) {
        Jedis jedis=new Jedis("192.168.159.133",6379);
        jedis.auth("qwe123");
        Transaction transaction=jedis.multi();
        transaction.set("Assertion", "com/shiro");
        transaction.set("b","bbb");
        transaction.set("c","ccc");
        transaction.exec();
        System.out.println("Assertion："+jedis.get("Assertion")+"  b："+jedis.get("b"));

        Jedis jedis1=new Jedis("192.168.159.134");
        jedis1.auth("qwe123");
        jedis1.set("c","ccc2");
        System.out.println(jedis1.keys("*"));
        System.out.println(jedis1.get("c"));

        List list=new ArrayList();
        List list1=new LinkedList();
        Vector vector=new Vector();

    }
}
