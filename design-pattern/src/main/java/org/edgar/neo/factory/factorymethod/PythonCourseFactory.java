package org.edgar.neo.factory.factorymethod;

public class PythonCourseFactory implements ICourseFactory {

    public ICourse create() {
        return new PythonCourse();
    }
}
