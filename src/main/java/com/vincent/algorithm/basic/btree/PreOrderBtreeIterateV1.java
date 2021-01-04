package com.vincent.algorithm.basic.btree;

import com.google.common.collect.Lists;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by chenjun on 2020-04-11 15:09
 *
 *
 *      3
 *    4    5
 * 6    7
 *
 * 思路，循环一直打到左边最底，并将对应的父节点放入结果集。右边依次入栈
 *当左边到底后，从栈中弹出元素
 */
public class PreOrderBtreeIterateV1 {


    public static void main(String[] args) {
        TreeNode treeNode = initTestTree();
        List<Integer> result = Lists.newArrayList();
        LinkedList<TreeNode> tempCache = new LinkedList();
        traverse(treeNode,result,tempCache);
        result.forEach(System.out::println);
    }

    private static void traverse(TreeNode treeNode, List<Integer> result, LinkedList<TreeNode> tempCache) {
        while (treeNode != null) {
            result.add(treeNode.val);
            if(treeNode.right != null) {
                tempCache.addFirst(treeNode.right);
            }
            if(treeNode.left != null) {
                treeNode = treeNode.left;
            } else {
                treeNode = tempCache.pollFirst();
            }
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
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

}
