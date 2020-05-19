package org.edgar.neo.decorator.general;

public class ConcreteDecoratorB extends Decorator{

    public ConcreteDecoratorB(Component component) {
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
