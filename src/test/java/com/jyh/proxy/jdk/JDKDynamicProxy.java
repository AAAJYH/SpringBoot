package com.jyh.proxy.jdk;

import com.jyh.thread.Sub;
import sun.misc.ProxyGenerator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Properties;

/**
 * @author jyh
 * @date 2019/11/27
 * @description
 * 次实现InvocationHandler相当于在要执行的方法前后加一些其他代码
 * Proxy类的apply方法会生成一个代理类，加载到jvm中，设置saveGeneratedFiles属性为true可以如磁盘，
 * 代理类重写了interface所有的方法包括equals、hashcode等，重写的方法中调用的是实现InvocationHandler的invoke方法
 *
 */

public class JDKDynamicProxy implements InvocationHandler {

    private Object target;

    public JDKDynamicProxy(Object target) {
        this.target = target;
    }

    /**
     * 获取被代理接口实例对象
     * this：在生成的代理类调用此类的invoke方法
     * @param <T>
     * @return
     */
    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Do something before");
        Object result = method.invoke(target, args);
        System.out.println("Do something after");
        return result;
    }

    public static void main(String[] args) {

        //保存生成的代理类的字节码文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        //jdk动态代理测试

        a b= new JDKDynamicProxy(new RealSubject()).getProxy();

        b.b();

    }

}
