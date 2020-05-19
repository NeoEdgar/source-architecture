package org.edgar.neo.liskovsutiution.simple;

public class Square extends Rectangle {

    private Integer length;

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    @Override
    public Integer getHeight() {
        return getLength();
    }

    @Override
    public void setHeight(Integer height) {
        setLength(height);
    }

    @Override
    public Integer getWidth() {
        return getLength();
    }

    @Override
    public void setWidth(Integer width) {
        setLength(width);
    }
}
