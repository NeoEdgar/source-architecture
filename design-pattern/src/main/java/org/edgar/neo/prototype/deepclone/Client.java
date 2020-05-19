package org.edgar.neo.prototype.deepclone;

import java.util.ArrayList;

public class Client {

    public static void main(String[] args) {
        ConcretePrototype prototype = new ConcretePrototype();
        prototype.setAge(25);
        prototype.setName("Neo");

        ArrayList<String> list = new ArrayList<String>();
        list.add("编程");
        list.add("书法");
        prototype.setHobbies(list);
        System.out.println(prototype);

        // 拷贝原型对象
        // copy了属性的内存地址的值
//        ConcretePrototype cloneType = prototype.clone();

        // copy了属性的内存地址对应的具体的值
//        ConcretePrototype cloneType = prototype.deepClone();

        //json实现
        ConcretePrototype cloneType = prototype.deepCloneJson();

        cloneType.getHobbies().add("美术");

        System.out.println(prototype);
        System.out.println(cloneType);
        System.out.println(prototype == cloneType);

        System.out.println(prototype.getHobbies());
        System.out.println(cloneType.getHobbies());
        System.out.println(prototype.getHobbies() == cloneType.getHobbies());


    }
}
