package org.edgar.neo.singleton.register;

/**
 * 注册式单例
 *
 * 优点：线程不能破坏
 *      valueOf 通过 key 去Map查找单例对象
 *      Map容器 先存储 key-value
 * 缺点：大批量 可能内存浪费
 *
 *      解决：参考IOC 容器式单例
 */
public enum EnumSingleton {

    //Enum

    SINGLETON;

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumSingleton getInstance() {
        return SINGLETON;
    }
}
