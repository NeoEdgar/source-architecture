package com.edgar.neo;

import java.lang.reflect.Proxy;
import java.util.ResourceBundle;

public class NeoConfiguration {

    public static final ResourceBundle sqlMappings;

    static {
        sqlMappings = ResourceBundle.getBundle("SqlMapper");
    }

    public <T> T getMapper(Class clazz, NeoSqlSession sqlSession) {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{clazz},
                new NeoMapperProxy(sqlSession));
    }

}
