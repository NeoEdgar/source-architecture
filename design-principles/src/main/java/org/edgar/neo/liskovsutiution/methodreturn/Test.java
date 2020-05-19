package org.edgar.neo.liskovsutiution.methodreturn;

public class Test {

    public static void main(String[] args) {
        Base child = new Child();
        System.out.println(child.mothod());
    }
}
