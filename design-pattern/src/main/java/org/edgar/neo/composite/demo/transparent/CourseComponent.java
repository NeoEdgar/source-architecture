package org.edgar.neo.composite.demo.transparent;

/**
 * 全部定义所需的方法
 */
public abstract class CourseComponent {

    public void addChild(CourseComponent componet) {
        throw new UnsupportedOperationException("不支持");
    }

    public void removeChild(CourseComponent componet) {
        throw new UnsupportedOperationException("不支持");
    }

    public String getName(CourseComponent componet) {
        throw new UnsupportedOperationException("不支持");
    }

    public Double getPrice(CourseComponent componet) {
        throw new UnsupportedOperationException("不支持");
    }


    public void print() {
        throw new UnsupportedOperationException("不支持");
    }

}
