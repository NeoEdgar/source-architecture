package org.edgar.neo.adapter.general.classadapter;

public class Test {


    public static void main(String[] args) {
        Target adapter = new Adapter();
        int request = adapter.request();
        System.out.println(request);
    }
}
