package com.jyh.Java并发编程的艺术;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;

/**
 * @author jyh
 * @date 2019/12/17
 * @description
 */

public class ConnectionDriver {

    static class ConnectionHandler implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if ("commit".equals(method.getName())) {
                TimeUnit.MILLISECONDS.sleep(100);
            }
            return null;
        }
    }

    public static final Connection createConnection() {
        return (Connection) Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(), new Class[]
                {Connection.class}, new ConnectionHandler());
    }

}
