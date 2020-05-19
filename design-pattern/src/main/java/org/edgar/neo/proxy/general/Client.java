package org.edgar.neo.proxy.general;

public class Client {

    public static void main(String[] args) {
        // new RealSubject() 只能对一个
        Proxy proxy = new Proxy(new RealSubject());
        proxy.request();
    }
}
