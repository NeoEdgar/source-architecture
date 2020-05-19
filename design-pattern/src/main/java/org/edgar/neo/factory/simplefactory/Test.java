package org.edgar.neo.factory.simplefactory;

import com.sun.org.slf4j.internal.LoggerFactory;
import java.util.Calendar;

public class Test {

    public static void main(String[] args) {
        CourseFactory courseFactory1 = new CourseFactory();
        ICourse iCourse1 = courseFactory1.createByName("java");
        iCourse1.record();

        CourseFactory courseFactory2 = new CourseFactory();
        ICourse iCourse2 = courseFactory2.createClassForName("org.edgar.neo.factory.simplefactory.JavaCourse");
        iCourse2.record();

        CourseFactory courseFactory3 = new CourseFactory();
        ICourse iCourse3 = courseFactory2.create(PythonCourse.class);
        iCourse3.record();

        // 简单工厂示例 查看源码
        // 思考 不符合开闭原则 为什么使用简单工厂？

//        Calendar.getInstance();
        LoggerFactory.getLogger(Test.class);
    }
}
