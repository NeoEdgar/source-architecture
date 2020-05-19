package org.edgar.neo.proxy.dynamicproxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKMeipo implements InvocationHandler {

    private IPerson target;

    public IPerson getInstance(IPerson target) {
        this.target = target;

        Class<? extends IPerson> clazz = target.getClass();

        return (IPerson) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(this.target, args);
        after();
        return result;
    }


    public void before() {
        System.out.println("JDKMeipo,开始物色...");
    }

    public void after() {
        System.out.println("匹配成功...");
    }

}
