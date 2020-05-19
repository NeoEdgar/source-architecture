package org.edgar.neo.factory.factorymethod;

public class Test {

    public static void main(String[] args) {
        ICourseFactory courseFactory = new JavaCourseFactory();
        ICourse iCourse = courseFactory.create();
        iCourse.record();

        ICourseFactory pythonCourseFactory = new PythonCourseFactory();
        ICourse iCourse1 = pythonCourseFactory.create();
        iCourse1.record();

//        ILoggerFactory();
    }
}
