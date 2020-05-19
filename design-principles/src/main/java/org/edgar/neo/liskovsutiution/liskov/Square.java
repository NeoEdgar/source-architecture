package org.edgar.neo.liskovsutiution.liskov;

public class Square implements QuadRangle {

    private Integer length;

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    //
    public Integer getWidth() {
        return length;
    }

    public Integer getHeight() {
        return length;
    }
}
