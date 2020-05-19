package org.edgar.neo.proxy.dynamicproxy.jdkproxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

public class Test {

    public static void main(String[] args) {
        JDKMeipo jdkMeipo = new JDKMeipo();

        IPerson zhangsan = jdkMeipo.getInstance(new Zhangsan());
        zhangsan.findLove();

//        IPerson zhaoliu = jdkMeipo.getInstance(new Zhaoliu());
//        zhaoliu.findLove();
//        zhaoliu.buyInsure();

        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{IPerson.class});
        try {
            FileOutputStream fos = new FileOutputStream("$Proxy0.class");
            fos.write(bytes);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

