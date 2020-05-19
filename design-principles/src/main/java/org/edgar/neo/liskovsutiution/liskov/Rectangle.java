package org.edgar.neo.liskovsutiution.liskov;

public class Rectangle implements QuadRangle {

    private Integer height;

    private Integer width;

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }
}
