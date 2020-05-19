package org.edgar.neo.singleton.threadlocal;

/**
 * 线程内安全单例
 */
public class ThreadLocalSingleton {

    private ThreadLocalSingleton() {
    }

    private static final ThreadLocal<ThreadLocalSingleton> threadLocalInstance =
        new ThreadLocal<ThreadLocalSingleton>(){
            @Override
            protected ThreadLocalSingleton initialValue() {
                return new ThreadLocalSingleton();
            }
        };

    public static ThreadLocalSingleton getInstance() {
        return threadLocalInstance.get();
    }
}
