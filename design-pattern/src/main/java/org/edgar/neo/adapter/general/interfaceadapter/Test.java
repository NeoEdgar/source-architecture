package org.edgar.neo.adapter.general.interfaceadapter;

public class Test {


    public static void main(String[] args) {
        final Target adapter = new Adapter(new Adaptee()){
            @Override
            public int request() {
                return adaptee.specificRequest() /10;
            }
        };
        int request = adapter.request();
        System.out.println(request);
    }
}
