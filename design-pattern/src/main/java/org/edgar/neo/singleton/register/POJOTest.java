package org.edgar.neo.singleton.register;

public class POJOTest {

    public static void main(String[] args) {
        Object instance = ContainerSingleton.getInstance("org.edgar.neo.singleton.register.POJOTest");
        Object instance2 = ContainerSingleton.getInstance("org.edgar.neo.singleton.register.POJOTest");

        System.out.println(instance);
        System.out.println(instance2);
        System.out.println(instance == instance2);
    }
}
