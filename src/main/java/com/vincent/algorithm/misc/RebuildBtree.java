package com.vincent.algorithm.misc;

public class RebuildBtree {
    public static void main(String[] args) {
        int[] preorder = {};
        int[] midorder = {};
        //TreeNode treeNode = rebuildTreeNode(preorder,midorder);
    }

    private  TreeNode rebuildTreeNode(int[] preorder, int[] inorder) {
        TreeNode treeNode = null;
        TreeNode currentRootNode = null;
        for(int i = 0;i<preorder.length;i++) {
            int currentRoot = preorder[i];
            if(i==0) {
                treeNode = new TreeNode(currentRoot);
                currentRootNode = treeNode;
            }
            int midorderIndex = findMidOrderLocationIndex(currentRoot,inorder);
            int mayLeftValue = preorder[i+1];
            TreeNode mayLeftNode = new TreeNode(mayLeftValue);
            int mayRightValue = preorder[i+2];
            TreeNode mayRightNode = new TreeNode(mayRightValue);
            if(!isInLeft(mayLeftValue,midorderIndex,inorder)) {
                new TreeNode(mayLeftValue);
                currentRootNode.right = mayLeftNode;
                i = i+1;
                currentRootNode =mayLeftNode;
                continue;
            }
            currentRootNode.left = mayLeftNode;
            if(!isInRight(mayRightValue,midorderIndex,inorder)) {
                currentRootNode.left.left=mayRightNode;
                i = i +2;
                currentRootNode = mayRightNode;
                continue;
            } else {
                currentRootNode.right = mayRightNode;
            }
            currentRootNode = mayRightNode;
        }
        return treeNode;
    }

    private  boolean isInRight(int mayRightValue, int midorderIndex, int[] midorder) {
        for(int i = midorderIndex;i>=0;i--) {
            if(midorder[i] == mayRightValue) {
                 return true;
            }
        }
        return false;
    }

    private  boolean isInLeft(int mayLeftValue, int midorderIndex, int[] midorder) {
        for(int i = 0;i<midorderIndex;i++) {
            if(midorder[i] == mayLeftValue) {
                return true;
            }
        }
        return false;
    }

    private  int findMidOrderLocationIndex(int currentRoot, int[] midorder) {
        for(int i =0;i<midorder.length;i++) {
            if(currentRoot == midorder[i]) {
                return i;
            }
        }
        throw new RuntimeException("can not find elemement");
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
