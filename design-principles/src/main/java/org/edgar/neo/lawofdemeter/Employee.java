package org.edgar.neo.lawofdemeter;

import java.util.ArrayList;

public class Employee {

    public void checkNumberOfCourses() {
        ArrayList<Course> courses = new ArrayList<Course>();
        for (int i = 0; i < 20; i++) {
            courses.add(new Course());
        }

        System.out.println("课程数量：" + courses.size());
    }
}
