package org.edgar.neo.singleton.lazy;

public class ExecutorThread implements Runnable {

    public void run() {
//        LazySimpleSingleton instance = LazySimpleSingleton.getInstance();
        LazyDoubleCheckSingleton instance = LazyDoubleCheckSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + ":" + instance);
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new ExecutorThread());
        Thread thread2 = new Thread(new ExecutorThread());
        thread1.start();
        thread2.start();
        System.out.println("End");
    }
}
