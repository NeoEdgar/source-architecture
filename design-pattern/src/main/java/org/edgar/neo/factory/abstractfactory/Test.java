package org.edgar.neo.factory.abstractfactory;

public class Test {

    public static void main(String[] args) {
        JavaCourseFactory javaCourseFactory = new JavaCourseFactory();
        javaCourseFactory.createNode().edit();
        javaCourseFactory.createVideo().record();
    }
}
