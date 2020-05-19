package org.edgar.neo.framework.aop;

import org.edgar.neo.framework.aop.aspect.NeoAdvice;
import org.edgar.neo.framework.aop.support.NeoAdvisedSupport;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

public class JDKDynamicAopProxy implements InvocationHandler {

    private NeoAdvisedSupport support;

    public JDKDynamicAopProxy(NeoAdvisedSupport support) {
        this.support = support;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Map<String, NeoAdvice> advices = support.getAdvices(method, null);
        Object returnValue;
        try {
            invokeAdvice(advices.get("before"));

            returnValue = method.invoke(this.support.getTarget(), args);

            invokeAdvice(advices.get("after"));
        } catch (Exception e) {
            invokeAdvice(advices.get("afterThrow"));
            throw e;
        }
        return returnValue;
    }

    private void invokeAdvice(NeoAdvice advice) {
        try {
            advice.getMethod().invoke(advice.getAspect());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), this.support.getTargetClass().getInterfaces(), this);
    }
}
