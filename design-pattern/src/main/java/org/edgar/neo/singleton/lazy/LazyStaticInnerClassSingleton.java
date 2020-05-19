package org.edgar.neo.singleton.lazy;

/**
 * LazyStaticInnerClassSingleton.class
 * LazyStaticInnerClassSingleton$LazyHolder.class //用的时候才加载
 *
 * 优点：写法优雅，利用了Java本身语法特点，性能高，避免了内存浪费
 * 缺点：能够被反射破坏
 *
 *      解决：构造方法抛异常
 *      缺点：又不优雅了
 *
 *          解决：
 */
public class LazyStaticInnerClassSingleton {

    private LazyStaticInnerClassSingleton() {
        if (LazyHolder.INSTANCE != null) {
            throw new RuntimeException("不允许非法访问");
        }
    }

    private static LazyStaticInnerClassSingleton getInstance(){
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final LazyStaticInnerClassSingleton INSTANCE = new LazyStaticInnerClassSingleton();
    }
}
