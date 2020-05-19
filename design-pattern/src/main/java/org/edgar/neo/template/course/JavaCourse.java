package org.edgar.neo.template.course;

public class JavaCourse extends AbstractCourse {

    private boolean needCheck = false;

    public void setNeedCheckHomework(boolean needCheck) {
        this.needCheck = needCheck;
    }

    @Override
    protected boolean needCheckHomework() {
        return needCheck;
    }

    @Override
    protected void checkHomework() {
        System.out.println("检查作业");
    }
}
