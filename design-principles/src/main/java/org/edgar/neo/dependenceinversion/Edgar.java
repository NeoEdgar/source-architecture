package org.edgar.neo.dependenceinversion;

public class Edgar {

//    public void studyJava() {
//        System.out.println("Edgar study java...");
//    }
//
//
//    public void studyPython() {
//        System.out.println("Edgar study python...");
//    }
//
//
//    public void studyAI() {
//        System.out.println("Edgar study AI...");
//    }


    public Edgar() {
    }


    // ------------------------------

    public void study(ICourse iCourse) {
        iCourse.study();
    }

    // ------------------------------

    private ICourse iCourse;

    public void study() {
        iCourse.study();
    }

    // 构造器注入
    public Edgar(ICourse iCourse) {
        this.iCourse = iCourse;
    }

    // set注入
    public void setiCourse(ICourse iCourse) {
        this.iCourse = iCourse;
    }
}
