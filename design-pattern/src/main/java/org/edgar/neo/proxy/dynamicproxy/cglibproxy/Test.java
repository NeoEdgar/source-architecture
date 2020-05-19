package org.edgar.neo.proxy.dynamicproxy.cglibproxy;

public class Test {

    public static void main(String[] args) {
        Zhangsan zhangsan = (Zhangsan)new CglibMeipo().getInstance(Zhangsan.class);
        zhangsan.findLove();

//        System.setProperty();
    }
}
