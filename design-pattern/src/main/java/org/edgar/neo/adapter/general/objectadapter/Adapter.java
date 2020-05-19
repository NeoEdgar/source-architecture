package org.edgar.neo.adapter.general.objectadapter;

/**
 * 类适配器：通过组合实现
 */
public class Adapter implements Target {

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    public int request() {
        return adaptee.specificRequest() / 10;
    }
}
