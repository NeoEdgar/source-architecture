package org.edgar.neo.openclose;

import java.math.BigDecimal;

public class Test {

    public static void main(String[] args) {
        Apple apple = new Apple(1, "apple", new BigDecimal("19.98"));
        System.out.println("ID:" + apple.getId() + "\n" +
                "Name:" + apple.getName() + "\n" +
                "Price:" + apple.getPrice() + "\n");



        Apple appleDiscount = new AppleDiscount(1, "apple", new BigDecimal("19.98"));
        System.out.println("ID:" + appleDiscount.getId() + "\n" +
                "Name:" + appleDiscount.getName() + "\n" +
                "Price:" + appleDiscount.getPrice() + "\n");

        AppleDiscount appleDiscount1 = new AppleDiscount(1, "apple", new BigDecimal("19.98"));
        System.out.println("ID:" + appleDiscount1.getId() +
                "\nName:" + appleDiscount1.getName() +
                "\nPrice:" + appleDiscount1.getPrice() +
                "\nDiscountPrice:" + appleDiscount1.getDiscountPrice());
    }
}
