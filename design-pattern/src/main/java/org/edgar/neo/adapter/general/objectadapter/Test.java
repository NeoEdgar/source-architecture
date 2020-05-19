package org.edgar.neo.adapter.general.objectadapter;

public class Test {


    public static void main(String[] args) {
        Target adapter = new Adapter(new Adaptee());
        int request = adapter.request();
        System.out.println(request);
    }
}
