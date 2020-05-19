package org.edgar.neo.decorator.guidebar;

public class LecturerDecorator extends GuideBarDecorator {

    public LecturerDecorator(GuideBar guideBar) {
        super(guideBar);
    }

    @Override
    public void getGuideBar() {
        super.getGuideBar();
        System.out.println("数据面板");
        System.out.println("学员管理");
    }
}
