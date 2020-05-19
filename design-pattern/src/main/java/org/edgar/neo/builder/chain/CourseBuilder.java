package org.edgar.neo.builder.chain;

/**
 * 链式编程
 *
 * 应用
 * StringBuilder
 * Mybatis CacheBuilder
 * Spring BeanDefinitionBuilder
 */
public class CourseBuilder {

    private Course course = new Course();

    public Course builder() {
        return course;
    }

    public CourseBuilder addName(String name) {
        course.setName(name);
        return this;
    }

    public CourseBuilder addPpt(String ppt) {
        course.setPpt(ppt);
        return this;
    }

    public CourseBuilder addVideo(String video) {
        course.setVideo(video);
        return this;
    }


    public CourseBuilder addNote(String note) {
        course.setNote(note);
        return this;
    }


    public CourseBuilder addHomework(String homework) {
        course.setHomework(homework);
        return this;
    }
}
