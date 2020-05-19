package org.edgar.neo.proxy.NeoProxy.client;


public class Test {

    public static void main(String[] args) {

        NeoMeipo neoMeipo = new NeoMeipo();
        IPerson zhangsan = neoMeipo.getInstance(new Zhangsan());
        zhangsan.findLove("女");

    }
}

