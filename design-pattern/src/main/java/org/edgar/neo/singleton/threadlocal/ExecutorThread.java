package org.edgar.neo.singleton.threadlocal;

public class ExecutorThread implements Runnable {

    public void run() {
        ThreadLocalSingleton instance = ThreadLocalSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + ":" + instance);

        System.out.println(Thread.currentThread().getName() + ":" + ThreadLocalSingleton.getInstance());

        System.out.println(Thread.currentThread().getName() + ":" + ThreadLocalSingleton.getInstance());
    }
}
