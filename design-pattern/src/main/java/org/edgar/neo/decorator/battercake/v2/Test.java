package org.edgar.neo.decorator.battercake.v2;

public class Test {

    public static void main(String[] args) {

        BatterCake batterCake;
        batterCake = new BaseBatterCake();

        batterCake = new EggDecorator(batterCake);

        batterCake = new SausageDecorator(batterCake);

        System.out.println(batterCake.getMeg() + "-" + batterCake.getPrice());
    }
}
