package org.edgar.neo.singleton.register;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        EnumSingleton instance = EnumSingleton.getInstance();
        instance.setData(new Object());

        // 反射
        Class clazz = EnumSingleton.class;
        Constructor constructor = clazz.getDeclaredConstructor(String.class, int.class);

        constructor.setAccessible(true);

        /**
         * if ((clazz.getModifiers() & Modifier.ENUM) != 0)
         *             throw new IllegalArgumentException("Cannot reflectively create enum objects");
         */
        Object o = constructor.newInstance();

    }
}
