package org.edgar.neo.factory.payfactory;

public class Test {

    public static void main(String[] args) {
        AbstractPayFactory payFactory = new IInternationalPayFactory();
        IPay applePay = payFactory.create();
        applePay.pay();
    }
}
