package org.edgar.neo.decorator.guidebar;

public class StudentDecorator extends GuideBarDecorator {

    public StudentDecorator(GuideBar guideBar) {
        super(guideBar);
    }

    @Override
    public void getGuideBar() {
        super.getGuideBar();
        System.out.println("作业");
        System.out.println("题库");
        System.out.println("成长墙");
    }
}
