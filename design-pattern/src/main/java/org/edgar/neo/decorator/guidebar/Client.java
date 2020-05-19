package org.edgar.neo.decorator.guidebar;

public class Client {

    public static void main(String[] args) {
        GuideBar guideBar;
        guideBar = new TouristGuideBar();
        guideBar = new StudentDecorator(guideBar);
        guideBar = new LecturerDecorator(guideBar);

        guideBar.getGuideBar();
    }
}
