package org.edgar.neo.adapter.general.classadapter;

/**
 * 类适配器：通过继承实现
 */
public class Adapter extends Adaptee implements Target{
    public int request() {
        return super.specificRequest() / 10;
    }
}
