package org.edgar.neo.factory.factorymethod;

public class JavaCourseFactory implements ICourseFactory {

    public ICourse create() {
        return new JavaCourse();
    }
}
