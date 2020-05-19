package org.edgar.neo.builder.general;

public class Director {

    public static void main(String[] args) {
        ConcreteBuilder builder = new ConcreteBuilder();

        System.out.println(builder.build());
    }
}
