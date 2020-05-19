package org.edgar.neo.factory.abstractfactory;

public class JavaCourseFactory extends CourseFactory {

    @Override
    protected INote createNode() {
        super.init();
        return new JavaNote();
    }

    @Override
    protected IVideo createVideo() {
        super.init();
        return new JavaVideo();
    }
}
