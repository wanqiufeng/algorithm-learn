package com.vincent.algorithm.basic.btree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenjun on 2020-04-11 15:09
 */
public class MidOrderBtreeRecursive {


    public static void main(String[] args) {

    }

    public List<Integer> traverse(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(root,result);
        return result;
    }

    private void traverse(TreeNode treeNode, List<Integer> result) {
        //先遍历左子树
        //遍历根节点
        //再遍历右子树
        if(treeNode == null) {
            return;
        }
        traverse(treeNode.left,result);
        result.add(treeNode.val);
        traverse(treeNode.right,result);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
