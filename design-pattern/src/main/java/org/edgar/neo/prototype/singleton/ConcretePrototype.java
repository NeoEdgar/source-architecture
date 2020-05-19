package org.edgar.neo.prototype.singleton;

import lombok.Data;

import java.util.List;

/**
 * 单例clone破坏
 *      解决：1、单例不实现Cloneable
 *           2、
 */
@Data
public class ConcretePrototype implements Cloneable {

    private int age;

    private String name;

    private List<String> hobbies;

    private ConcretePrototype() {
    }

    private static final ConcretePrototype instance = new ConcretePrototype();

    public static ConcretePrototype getInstance() {
        return instance;
    }

//    @Override
//    protected ConcretePrototype clone() {
//        try {
//            return (ConcretePrototype)super.clone();
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    @Override
    protected ConcretePrototype clone() {
        return instance;
    }


}
