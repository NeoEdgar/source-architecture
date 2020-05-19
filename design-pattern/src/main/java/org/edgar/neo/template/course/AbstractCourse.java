package org.edgar.neo.template.course;

public abstract class AbstractCourse {

    protected final void createCourse(){
        // 发布预习资料
        postPreResource();

        // 制作课件
        createPPT();

        // 直播授课
        liveVideo();

        // 上课课后资料
        postResource();

        // 布置作业
        postHomework();

        if (needCheckHomework()){
            checkHomework();
        }
    }

    // 钩子方法
    protected boolean needCheckHomework(){
        return false;
    }

    protected abstract void checkHomework();


    protected void postHomework(){
        System.out.println("布置作业");
    }

    protected void postResource(){
        System.out.println("上课课后资料");
    }

    protected void liveVideo(){
        System.out.println("直播授课");
    }

    protected void createPPT(){
        System.out.println("制作课件");
    }

    protected void postPreResource(){
        System.out.println("发布预习资料");
    }
}
