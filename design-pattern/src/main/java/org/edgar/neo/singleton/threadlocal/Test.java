package org.edgar.neo.singleton.threadlocal;

public class Test {

    public static void main(String[] args) {
        ThreadLocalSingleton instance = ThreadLocalSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + ":" + instance);
        System.out.println(Thread.currentThread().getName() + ":" + ThreadLocalSingleton.getInstance());
        System.out.println(Thread.currentThread().getName() + ":" + ThreadLocalSingleton.getInstance());

        Thread thread1 = new Thread(new ExecutorThread());
        Thread thread2 = new Thread(new ExecutorThread());
        thread1.start();
        thread2.start();
        System.out.println("End");
    }
}
