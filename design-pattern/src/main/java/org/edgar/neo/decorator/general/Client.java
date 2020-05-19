package org.edgar.neo.decorator.general;

public class Client {

    public static void main(String[] args) {

        ConcreteComponent concreteComponent = new ConcreteComponent();

        ConcreteDecoratorA decoratorA = new ConcreteDecoratorA(concreteComponent);
        decoratorA.operation();

        ConcreteDecoratorB decoratorB = new ConcreteDecoratorB(concreteComponent);
        decoratorB.operation();

        ConcreteDecoratorB decoratorBandA = new ConcreteDecoratorB(decoratorA);
        decoratorBandA.operation();

    }
}
