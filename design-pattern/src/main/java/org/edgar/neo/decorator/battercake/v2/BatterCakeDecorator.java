package org.edgar.neo.decorator.battercake.v2;

public class BatterCakeDecorator extends BatterCake {


    // 装饰器必要操作
    private BatterCake batterCake;

    public BatterCakeDecorator(BatterCake batterCake) {
        this.batterCake = batterCake;
    }


    @Override
    protected String getMeg() {
        return batterCake.getMeg();
    }

    @Override
    protected Integer getPrice() {
        return batterCake.getPrice();
    }
}
