package org.edgar.neo.factory.abstractfactory;

public class PythonCourseFactory extends CourseFactory {

    @Override
    protected INote createNode() {
        super.init();
        return new PythonNote();
    }

    @Override
    protected IVideo createVideo() {
        super.init();
        return new PythonVideo();
    }
}
