package org.edgar.neo.proxy.general;

public class Proxy implements ISubject {

    private ISubject subject;

    // 构造
    public Proxy(ISubject subject) {
        this.subject = subject;
    }

    public void request() {
        before();
        subject.request();
        after();
    }

    public void before() {
        System.out.println("called before request()...");
    }

    public void after() {
        System.out.println("called after request()...");
    }
}
