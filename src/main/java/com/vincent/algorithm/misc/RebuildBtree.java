package com.vincent.algorithm.misc;

public class RebuildBtree {
    public static void main(String[] args) {
        int[] preorder = {};
        int[] midorder = {};
        TreeNode treeNode = rebuildTreeNode(preorder,midorder);
    }

    private static TreeNode rebuildTreeNode(int[] preorder, int[] midorder) {
        for(int i=0 ;i<preorder.length;i++) {
            if(i==0) {
                TreeNode();
            }
        }
        return null;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
