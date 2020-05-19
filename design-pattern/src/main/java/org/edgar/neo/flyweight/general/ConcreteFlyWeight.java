package org.edgar.neo.flyweight.general;

/**
 * 具体享元角色
 */
public class ConcreteFlyWeight implements IFlyWeight {

    private String intrinsicState;

    public ConcreteFlyWeight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    public void operation(String extrinsicState) {
        System.out.println("Object address: " + System.identityHashCode(this));
        System.out.println("intrinsicState: " + this.intrinsicState);
        System.out.println("extrinsicState: " + extrinsicState);
    }
}
