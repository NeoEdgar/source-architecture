package org.edgar.neo.proxy.NeoProxy.client;

import org.edgar.neo.proxy.NeoProxy.NeoClassLoader;
import org.edgar.neo.proxy.NeoProxy.NeoInvocationHandler;
import org.edgar.neo.proxy.NeoProxy.NeoProxy;

import java.lang.reflect.Method;

public class NeoMeipo implements NeoInvocationHandler {
    //代理对象
    private IPerson target;

    public IPerson getInstance(IPerson person) {
        this.target = person;
        Class<? extends IPerson> clazz = person.getClass();
        return  (IPerson) NeoProxy.newProxyInstance(new NeoClassLoader(), clazz.getInterfaces(), this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(this.target,args);
        after();
        return result;
    }

    private void after() {
        System.out.println("双方同意，开始交往");
    }

    private void before() {
        System.out.println("我是媒婆，已经收集到你的需求，开始物色");
    }
}
