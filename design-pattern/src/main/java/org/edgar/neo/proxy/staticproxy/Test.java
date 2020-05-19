package org.edgar.neo.proxy.staticproxy;

public class Test {
    public static void main(String[] args) {
        // new Zhangsan() 只能对一个，别人不行
        FatherProxy zhangLaoSan = new FatherProxy(new Zhangsan());
        zhangLaoSan.findLove();
    }
}
