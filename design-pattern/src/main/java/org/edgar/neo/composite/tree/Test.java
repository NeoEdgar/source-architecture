package org.edgar.neo.composite.tree;

public class Test {

    public static void main(String[] args) {
        TreeNode first = new TreeNode("一级节点");
        first.show();

        TreeNode second = new TreeNode("二级节点-1");
        TreeNode second2 = new TreeNode("二级节点-2");
        first.add(second);
        first.add(second2);
        second.show();
        second2.show();

        TreeNode third = new TreeNode("三级节点");
        second.add(third);
        third.show();

        third.add(second);
        third.show();

    }
}
