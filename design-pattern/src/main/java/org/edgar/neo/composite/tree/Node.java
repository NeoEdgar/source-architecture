package org.edgar.neo.composite.tree;

public abstract class Node {

    protected String name;

    protected String xpath;

    public Node(String name) {
        this.name = name;
    }

    public abstract void show();

    public abstract String getXpath();

}
