package org.edgar.neo.decorator.battercake.v2;

public class SausageDecorator extends BatterCakeDecorator {

    public SausageDecorator(BatterCake batterCake) {
        super(batterCake);
    }

    @Override
    protected String getMeg() {
        return super.getMeg() + "1个香肠";
    }

    @Override
    protected Integer getPrice() {
        return super.getPrice() + 2;
    }
}
