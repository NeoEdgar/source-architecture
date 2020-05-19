package org.edgar.neo.strategy.marketing;

public class EmptyStrategy implements IMarketing {
    public void doSell() {

        System.out.println("无优惠");
    }
}
