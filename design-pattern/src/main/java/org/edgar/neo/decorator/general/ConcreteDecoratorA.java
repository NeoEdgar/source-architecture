package org.edgar.neo.decorator.general;

public class ConcreteDecoratorA extends Decorator{

    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        operationFirst();
        super.operation();
        operationLast();
    }

    private void operationFirst() {

    }

    private void operationLast() {

    }
}
