package org.edgar.neo.adapter.general.interfaceadapter;

/**
 * 类适配器：通过组合实现
 */
public abstract class Adapter implements Target {

    protected Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    public int request() {
        return adaptee.specificRequest() / 10;
    }

    public int request1() {
        return 0;
    }

    public int request2() {
        return 0;
    }

    public int request3() {
        return 0;
    }

    public int request4() {
        return 0;
    }
}
