package org.edgar.neo.liskovsutiution.methodparam;


import java.util.HashMap;

public class Test {

    public static void main(String[] args) {
        Child child = new Child();
        child.method(new HashMap());
    }
}
