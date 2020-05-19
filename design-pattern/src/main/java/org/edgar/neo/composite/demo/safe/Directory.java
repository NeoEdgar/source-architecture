package org.edgar.neo.composite.demo.safe;

/**
 * 跟节点抽象，只定义公共方法
 */
public abstract class Directory {

    protected String name;

    public abstract void show();

    public Directory(String name) {
        this.name = name;
    }
}
