package org.edgar.neo.proxy.staticproxy;

public class FatherProxy implements IPerson {

    private Zhangsan zhangsan;

    public FatherProxy(Zhangsan zhangsan) {
        this.zhangsan = zhangsan;
    }

    public void findLove() {
        System.out.println("张老三开始物色...");
        zhangsan.findLove();
        System.out.println("开始交往");
    }
}
