package org.edgar.neo.builder.chain;

public class Test {

    public static void main(String[] args) {
        CourseBuilder builder = new CourseBuilder();

        builder.addName("设计模式")
            .addPpt("PPT")
            .addVideo("视频")
            .addHomework("课后作用");

        System.out.println(builder.builder());
    }
}
