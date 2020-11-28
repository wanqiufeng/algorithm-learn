package com.vincent.algorithm.basic.btree;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by chenjun on 2020-04-11 15:09
 *
 *
 *      3
 *    4    5
 * 6    7
 */
public class AllOrderBtreeRecursive {

    public static void main(String[] args) {
        TreeNode treeNode = initTestTree();
        List<Integer> result = Lists.newArrayList();
        traversePost(treeNode,result);
        result.forEach(System.out::println);
    }

    private static void traverseMid(TreeNode treeNode, List<Integer> result) {
        //不为空，则递归左子树
        //为空或遍历完，则在结果集中放入自己
        //然后是遍历右子树

        if(treeNode == null) {
            return;
        }
        traverseMid(treeNode.left,result);
        result.add(treeNode.val);
        traverseMid(treeNode.right,result);
    }

    private static void traversePre(TreeNode treeNode, List<Integer> result) {
        //不为空，则递归左子树
        //为空或遍历完，则在结果集中放入自己
        //然后是遍历右子树

        if(treeNode == null) {
            return;
        }
        result.add(treeNode.val);
        traversePre(treeNode.left,result);
        traversePre(treeNode.right,result);
    }


    private static void traversePost(TreeNode treeNode, List<Integer> result) {
        //不为空，则递归左子树
        //为空或遍历完，则在结果集中放入自己
        //然后是遍历右子树

        if(treeNode == null) {
            return;
        }
        traversePost(treeNode.left,result);
        traversePost(treeNode.right,result);
        result.add(treeNode.val);
    }


    private static TreeNode initTestTree() {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(6);
        TreeNode treeNode5 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right =treeNode5;
        return treeNode1;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
