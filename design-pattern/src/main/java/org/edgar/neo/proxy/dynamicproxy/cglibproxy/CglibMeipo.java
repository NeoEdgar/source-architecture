package org.edgar.neo.proxy.dynamicproxy.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibMeipo implements MethodInterceptor {

    public Object getInstance(Class<?> clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        before();
        Object result = proxy.invokeSuper(obj, args);
        after();
        return result;
    }


    public void before() {
        System.out.println("CglibMeipo, 开始物色...");
    }

    public void after() {
        System.out.println("匹配成功...");
    }

}
