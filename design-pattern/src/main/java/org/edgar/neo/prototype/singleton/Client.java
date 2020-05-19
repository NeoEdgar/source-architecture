package org.edgar.neo.prototype.singleton;

import java.util.ArrayList;

public class Client {

    public static void main(String[] args) {
        ConcretePrototype prototype = ConcretePrototype.getInstance();
        prototype.setAge(25);
        prototype.setName("Neo");

        ArrayList<String> list = new ArrayList<String>();
        list.add("编程");
        list.add("书法");
        prototype.setHobbies(list);
        System.out.println(prototype);

        // 拷贝原型对象
        // copy了对象的属性的内存地址的值
        // 主对象地址不一样，破坏了单例
        ConcretePrototype cloneType = prototype.clone();
        cloneType.getHobbies().add("美术");

        System.out.println(prototype);
        System.out.println(cloneType);
        System.out.println(prototype == cloneType);

        System.out.println(prototype.getHobbies());
        System.out.println(cloneType.getHobbies());
        System.out.println(prototype.getHobbies() == cloneType.getHobbies());

    }
}
