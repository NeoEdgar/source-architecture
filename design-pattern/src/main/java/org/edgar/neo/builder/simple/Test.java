package org.edgar.neo.builder.simple;

public class Test {

    public static void main(String[] args) {
        CourseBuilder builder = new CourseBuilder();

        builder.addName("设计模式");
        builder.addPpt("PPT");
        builder.addVideo("视频");

        System.out.println(builder.builder());
    }
}
