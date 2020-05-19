package org.edgar.neo.singleton.hungry;

/**
 * 饿汉式
 *
 * 优点：执行效率高，性能高，没有任何的锁
 * 缺点：某些情况下，可能会造成内存浪费
 */
public class HungryStaticSingleton {

    private HungryStaticSingleton() {
    }

    public static final HungryStaticSingleton hungrySingleton;

    static {
        hungrySingleton = new HungryStaticSingleton();
    }

    public static HungryStaticSingleton getInstance() {
        return hungrySingleton;
    }
}
