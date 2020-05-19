package org.edgar.neo.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 容器式单例 对 枚举单例的升级
 * 缺点：线程安全问题
 *
 *      解决：
 *           思路：参考Spring AbstractBeanFactory
 */
public class ContainerSingleton {

    private ContainerSingleton() {
    }

    private static Map<String, Object> IOC = new ConcurrentHashMap<String, Object>();

    public static Object getInstance(String classname) {

        if (!IOC.containsKey(classname)){
            try {
                Object instance = Class.forName(classname).newInstance();
                IOC.put(classname, instance);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return IOC.get(classname);
    }

    public static Object getInstanceThreadSafety(String classname) {

        if (!IOC.containsKey(classname)) {
            synchronized(ContainerSingleton.class) {
                Object instance = IOC.get(classname);
                if (instance == null){
                    try {
                        instance = Class.forName(classname).newInstance();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    IOC.put(classname, instance);
                }else {
                    return instance;
                }
            }
        }
        return IOC.get(classname);
    }
}
