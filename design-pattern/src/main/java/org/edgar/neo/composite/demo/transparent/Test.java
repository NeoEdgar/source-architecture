package org.edgar.neo.composite.demo.transparent;

public class Test {

    public static void main(String[] args) {
        System.out.println("-------透明的组合模式");

        CourseComponent java = new Course("Java", new Double(8200));
        CourseComponent ai = new Course("AI", new Double(8200));

        CourseComponent coursePackage = new CoursePackage("Java架构师路径", 2);

        CourseComponent design = new Course("设计模式", new Double(8200));
        CourseComponent source = new Course("源码分析", new Double(8200));
        CourseComponent softKill = new Course("软技能", new Double(8200));

        coursePackage.addChild(design);
        coursePackage.addChild(source);
        coursePackage.addChild(softKill);


        CourseComponent catalog = new CoursePackage("总目录", 1);

        catalog.addChild(java);
        catalog.addChild(ai);
        catalog.addChild(coursePackage);

        catalog.print();

    }
}
