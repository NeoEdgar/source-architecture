package org.edgar.neo.decorator.guidebar;

public class GuideBarDecorator extends GuideBar {

    private GuideBar guideBar;

    public GuideBarDecorator(GuideBar guideBar) {
        this.guideBar = guideBar;
    }

    public void getGuideBar() {
        guideBar.getGuideBar();
    }
}
