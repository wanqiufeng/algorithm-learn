package com.vincent.algorithm.basic.btree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenjun on 2020-04-11 14:57
 */
public class PreOrderBtree {

    public static void main(String[] args) {

    }


    public List<Integer> traverse(TreeNode treeNode) {
        //定义一个集合，已经遍历的元素放集合中
        List<Integer> result = new ArrayList<>();
        traverse(treeNode,result);
        return result;
    }

    private void traverse(TreeNode treeNode, List<Integer> result) {
        //如果当前treeNode为空，则返回
        //先将根节点放入集合
        //然后遍历左子树
        //遍历右子树
        if(treeNode == null) {
            return;
        }
        result.add(treeNode.val);
        traverse(treeNode.left,result);
        traverse(treeNode.right,result);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}



