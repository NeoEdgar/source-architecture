package org.edgar.neo.singleton.lazy;

/**
 * 懒汉式
 *
 * 优点：使用时加载，节省了内存
 * 缺点：线程不安全
 *      正常顺序执行，也可能是后者覆盖了前者
 *
 *      解决：synchronized
 *      缺点：性能低
 *
 *          解决：双重检查 {@link LazyDoubleCheckSingleton}
 *          缺点：指令重排序
 *
 *              解决：加 volatile
 *              LazyDoubleCheckSingleton 目前不够优雅
 *
 *
 */
public class LazySimpleSingleton {

    private LazySimpleSingleton() {
    }

    private static LazySimpleSingleton lazySimpleSingleton;

    public synchronized static LazySimpleSingleton getInstance() {
        if (lazySimpleSingleton == null) {
            lazySimpleSingleton = new LazySimpleSingleton();
        }
        return lazySimpleSingleton;
    }
}
