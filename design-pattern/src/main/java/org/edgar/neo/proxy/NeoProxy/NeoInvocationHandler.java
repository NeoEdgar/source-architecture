package org.edgar.neo.proxy.NeoProxy;

import java.lang.reflect.Method;

public interface NeoInvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
