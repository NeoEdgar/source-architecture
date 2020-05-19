package org.edgar.neo.prototype.shallow;

import lombok.Data;

import java.util.List;

/**
 * JDK ArrayList、HashMap
 */
@Data
public class ConcretePrototype implements Cloneable {

    private int age;

    private String name;

    private List<String> hobbies;

    @Override
    protected ConcretePrototype clone() {
        try {
            return (ConcretePrototype)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }


}
