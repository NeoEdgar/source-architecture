package org.edgar.neo.decorator.battercake.v1;

public class BatterCakeAddEgg extends BatterCake{

    protected String getMeg() {
        return super.getMeg()+"+鸡蛋";
    }

    protected Integer getPrice() {
        return super.getPrice() + 1;
    }
}
