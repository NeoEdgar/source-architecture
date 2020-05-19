package org.edgar.neo.proxy.general;

public class RealSubject implements ISubject {

    public void request() {
        System.out.println("real subject");
    }
}
