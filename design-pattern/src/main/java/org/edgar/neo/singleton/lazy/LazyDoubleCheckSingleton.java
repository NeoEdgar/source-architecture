package org.edgar.neo.singleton.lazy;

public class LazyDoubleCheckSingleton {

    private LazyDoubleCheckSingleton() {
    }

    // volatile 防止指令重排序
    public volatile static LazyDoubleCheckSingleton lazyDoubleCheckSingleton;

    public static LazyDoubleCheckSingleton getInstance() {
        // 检测是否阻塞
        if (lazyDoubleCheckSingleton == null) {
            synchronized (LazyDoubleCheckSingleton.class){
                // 检测是否重新创建实例
                if (lazyDoubleCheckSingleton == null){
                    lazyDoubleCheckSingleton = new LazyDoubleCheckSingleton();
                }
            }
        }
        return lazyDoubleCheckSingleton;
    }
}
