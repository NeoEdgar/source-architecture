package org.edgar.neo.decorator.battercake.v1;

public class Test {

    public static void main(String[] args) {
        BatterCake batterCake = new BatterCake();
        System.out.println(batterCake.getMeg()+"-"+batterCake.getPrice());


        BatterCakeAddEgg batterCakeAddEgg = new BatterCakeAddEgg();
        System.out.println(batterCakeAddEgg.getMeg()+"-"+batterCakeAddEgg.getPrice());

    }
}
