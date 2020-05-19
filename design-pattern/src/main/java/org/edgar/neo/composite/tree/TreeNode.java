package org.edgar.neo.composite.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode extends Node {

//    private Integer level;

    private List<Node> nodes;

    public TreeNode(String name) {
        super(name);
        this.xpath = getXpath() + name;
        this.nodes = new ArrayList<Node>();
    }


    public boolean add(Node node) {
        node.xpath = this.xpath + node.getXpath();
        return this.nodes.add(node);
    }

    public String getXpath() {
        if (this.xpath == null){
            return "/";
        } else {
            return this.xpath;
        }
    }

    @Override
    public void show() {
        System.out.println(this.xpath);
    }
}
