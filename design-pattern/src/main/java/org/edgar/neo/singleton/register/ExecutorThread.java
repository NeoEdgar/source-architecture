package org.edgar.neo.singleton.register;


public class ExecutorThread implements Runnable {

    public void run() {
        // 1.0
//        Object instance = ContainerSingleton.getInstance("org.edgar.neo.singleton.register.POJOTest"); //线程不安全

        // 2.0
        Object instance = ContainerSingleton.getInstanceThreadSafety("org.edgar.neo.singleton.register.POJOTest"); //线程安全

        System.out.println(Thread.currentThread().getName() + ":" + instance);
        System.out.println(Thread.currentThread().getName() + ":" + ContainerSingleton.getInstanceThreadSafety("org.edgar.neo.singleton.register.POJOTest"));
    }

    public static void main(String[] args) {

        Thread thread1 = new Thread(new ExecutorThread());
        Thread thread2 = new Thread(new ExecutorThread());
        thread1.start();
        thread2.start();
        System.out.println("End");

        /**
         * End
         *   Thread-0:org.edgar.neo.singleton.register.POJOTest@7b69b864
         *   Thread-1:org.edgar.neo.singleton.register.POJOTest@18e7d47c
         */


    }
}
