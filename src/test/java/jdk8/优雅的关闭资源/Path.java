package jdk8.优雅的关闭资源;

import java.io.File;
import java.io.InputStream;

public class Path implements AutoCloseable {

    public void print() {
        System.out.println("使用资源");
    }

    @Override
    public void close() throws Exception {
        System.out.println("实现AutoCloseable类close()，在try中声明资源，try catch 结束后会自动调用此方法，释放资源");
    }

}
