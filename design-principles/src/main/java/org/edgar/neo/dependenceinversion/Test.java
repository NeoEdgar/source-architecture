package org.edgar.neo.dependenceinversion;

public class Test {

    public static void main(String[] args) {
//============== v1 ================
//        Edgar edgar = new Edgar();
//        edgar.studyJavava();
//        edgar.studyPython();
//        edgar.studyAI();

//============== v2 ================
//        Edgar edgar = new Edgar();
//        edgar.study(new JavaCourse());
//        edgar.study(new PythonCourse());


//============== v3 ================
//        Edgar edgar = new Edgar(new JavaCourse());
//        edgar.study();

//============== v4 ================
        Edgar edgar = new Edgar();
        edgar.setiCourse(new PythonCourse());
        edgar.study();

    }
}
