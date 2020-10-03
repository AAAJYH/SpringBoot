package com.jyh;

import com.jyh.base.BaseTest;
import com.jyh.反射.Person;
import org.springframework.util.Assert;
import org.xerial.snappy.Snappy;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.*;
import java.util.zip.GZIPInputStream;

/**
 * @author: 姬雨航
 * @date: 2019/7/29 11:32
 * @description：
 */

public class Test extends BaseTest {
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    @org.junit.Test
    public void hashMap() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "zhangsan");
        map.put("age", "19");
    }


        public static int printFIb(int num) {
            if (num==1||num==2) {
                return 1;
            }else {
                return printFIb(num-1)+printFIb(num-2);
            }
        }

        @org.junit.Test
        public void aa() {
            for (int i=1;i<=10;i++) {
                System.out.println("第"+i+"="+printFIb(i));
            }
        }

    @org.junit.Test
    public void b() {
        SimpleDateFormat s = new SimpleDateFormat("YYYYMMDDHHmmss");
        System.out.println(s.format(new Date()));

        System.out.println("1右移1" + (2 << 1));
        System.out.println(1 ^ 0);
        System.out.println(0 ^ 0);

        List a = Collections.singletonList(1);
        System.out.println(a.get(0));
        List list = Arrays.asList(1, 2);

        list.add(1);
        System.out.println("123456".length());
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();

        Map<String, String> map = new ConcurrentHashMap<>();
        map.put("name", "jyh");

        List<Person> l = new ArrayList<>();
        Person person = new Person();
        person.setAge(11);
        person.setName("hh");

        l.add(person);

        person.setName("bb");
        person.setAge(55);
        l.add(person);

        System.out.println(l);
        new ArrayList<>(null);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("1");

    }

//    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
//        System.out.println(8 << 2);
//
//        MapMethod map = new ConcurrentHashMap<String, String>();
//        map.put("1", "jyh");
//        map.put("2", "16");
//        map.put("3", "16");
//        map.put("4", "16");
//        map.put("5", "16");
//        map.put("6", "16");
//        map.put("7", "16");
//        map.put("8", "16");
//        map.put("9", "16");
//        map.put("10", "16");
//        map.put("11", "16");
//        map.put("12", "16");
//        map.put("13", "16");
//        map.put("14", "16");
//        map.put("15", "16");
//        map.put("16", "16");
//        map.put("17", "16");
//
//        map.get("");
//
//        System.out.println(1 << 30);
//        System.out.println(1 << 16);
//
//        System.out.println(1 >>> 1);
//        System.out.println(1 >>> 2);
//        System.out.println(1 >>> 4);
//        System.out.println(1 >>> 8);
//        System.out.println(1 >>> 16);
//
//        int a = 5; // 0000 0101
//        int b = 3; // 0000 0011
//        a |= b; // 0000 00111
//        System.out.println(a);
//    }

    public void conditionWait() {
        lock.lock();
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void conditionSignal() throws InterruptedException {
        lock.lock();
        try {
             condition.signal();
        }finally {
            lock.unlock();
        }
    }

    @org.junit.Test
    public void a() {
        Map<String, StringBuilder> map = new HashMap<>();

//        String key = map.get("name");
//        if (key == null) {
//            key = "name";
//            map.put("name", "张三");
//        }
//        map.put("age", "20");
        List<String> l = new ArrayList<>();
        l.add("hhh");
        map.computeIfAbsent("age", k -> new StringBuilder("")).append("fdsfdf");


        System.out.println(map.get("name"));
        System.out.println(map.get("age"));
//        System.out.println("".equals("   "));
//        TestA a = new TestA();
//        a.setFlag(false);
//        a.person = new Person();
//        a.person.name = "123212";
//
//        System.out.println(a.getPerson().getName());
//        a.setPerson(new Person());
//        a.getPerson().setName("nihaoaaa");
//
//        MapMethod<String, String> map = new HashMap<>();
//        map.put("name", "张三");
//        a.setMap(map);
//
//        MapMethod<String, String> map1 = a.getMap();
//        a.getMap().put("age", "15");
//        map1.remove("name");
//
//        System.out.println(a.getPerson().toString());
//        System.out.println(a.getMap().containsKey("name"));
    }

    private void b(Double a) {
        a = 23.01;
    }

    @org.junit.Test
    public void bbb() {
        Map<String, String> map1 = new HashMap<>();
        map1.computeIfAbsent("name", this::ddd);

        Assert.isTrue(true, "");
    }

    public String ddd(String name) {
        return "bbb";
    }

    @org.junit.Test
    public void ccc() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        for (Integer integer : list) {
            list.remove(integer);
        }

//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
//        for (Integer integer : list) {
//            list.remove(integer);
//        }
    }

    @org.junit.Test
    public void cccc() throws IOException {
        String dataString = "The quick brown fox jumps over the lazy dog";
        byte[] compressed = Snappy.compress(dataString.getBytes("UTF-8"));
        byte[] uncompressed = Snappy.uncompress(compressed);
        String result = new String(uncompressed, "UTF-8");
        System.out.println(result);
    }

    @org.junit.Test
    public void abc() throws IOException {
        String a = "----------------------------   �\u0001��\n" +
                "z\n" +
                "9\n" +
                "\b__name__\u0012-mysql_global_variables_innodb_read_io_threads\n" +
                "\u001E\n" +
                "\binstance\u0012\u0012192.168.31.80:9101\n" +
                "\u000B\n" +
                "\u0003job\u0012\u0004ser1\u0012\u0010\t\u0000\u0000\u0000\u0000\u0000\u0000\u0010@\u0010Ʋ���.\n" +
                "t\n" +
                "2\n" +
                "\b\u0015|\u0004&mV|\u0000@net_retry_count\n" +
                "\u001F\u001Du\u0014\u0013192.1\tu\f168:>v\u0000\u00002\u0015v $@\u0010�°��.    ------------------------------";

//        String b = this.uncompressToString(a.getBytes());
//        SnappyCompressorInputStream snappyCompressorInputStream = new SnappyCompressorInputStream()

//        byte[] c = Base32.decode(a);
//        System.out.println(c.toString());
//                Remote.WriteRequest writeRequest = Remote.WriteRequest.parseFrom(a.getBytes());
//        byte[] bytes = Snappy.uncompress(c);

                Assert.isTrue(true, "");

    }
    /**
     * "utf-8"编码解压
     * @param bytes 要解压的字节数组
     * @return 字节数组
     */
    public static String uncompressToString(byte[] bytes) {
        return uncompressToString(bytes, "UTF-8");
    }

    /**
     * 指定编码解压
     * @param
     * @param encoding 编码
     * @return 字节数组
     */
    public static String uncompressToString(byte[] bytes, String encoding) {
        if (null == bytes || bytes.length == 0) {
            return null;
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        GZIPInputStream unGzip;
        try {
            unGzip = new GZIPInputStream(bais);
            byte[] buffer = new byte[256];
            int n;
            while ((n = unGzip.read(buffer)) >= 0) {
                baos.write(buffer, 0, n);
            }
            return baos.toString(encoding);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}


