package org.edgar.neo.singleton.lazy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<?> clazz = LazyStaticInnerClassSingleton.class;
        Constructor<?> constructor = clazz.getDeclaredConstructor(null);

        constructor.setAccessible(true);

        Object o = constructor.newInstance();
        System.out.println(o);

        LazyStaticInnerClassSingleton instance = (LazyStaticInnerClassSingleton)constructor.newInstance();
        System.out.println(instance);
    }
}
