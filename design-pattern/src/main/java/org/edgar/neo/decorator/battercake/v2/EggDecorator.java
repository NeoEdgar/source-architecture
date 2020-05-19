package org.edgar.neo.decorator.battercake.v2;

public class EggDecorator extends BatterCakeDecorator {

    public EggDecorator(BatterCake batterCake) {
        super(batterCake);
    }

    @Override
    protected String getMeg() {
        return super.getMeg() + "1个鸡蛋";
    }

    @Override
    protected Integer getPrice() {
        return super.getPrice() + 1;
    }
}
