package com.vincent.algorithm.basic.btree;

import com.google.common.collect.Lists;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by chenjun on 2020-04-11 15:48
 *
 * 不采用递归，对树进行后序遍历。其思想就是直接使用前序遍历方式，完成遍历入栈
 *
 * 其中有个巧妙的思想，利用LinkedList是一个双端队列的特点，在遍历时使用其FIFO。
 *
 */
public class PostOrderBtreeIterate {
    public static void main(String[] args) {
        TreeNode treeNode = initTestTree();
        List<Integer> traverse = traverse(treeNode);
        traverse.forEach(System.out::println);
    }

    public static List<Integer> traverse(TreeNode root) {
        LinkedList<Integer> resultStack = new LinkedList<>();
        if(root == null) return resultStack;
        LinkedList<TreeNode> tempStack = new LinkedList<>();


        tempStack.add(root);
        while (!tempStack.isEmpty()) {
            TreeNode treeNode1 = tempStack.pollLast();
            if(treeNode1 == null) continue;//当前节点为null，但tempStack中可能还有其他节点
            resultStack.addFirst(treeNode1.val);//这里addFirst方法会让所有新插入的元素放到最前面，也即栈顶，这样循环遍历时，先进的元素反而后出，自动完成倒序
            tempStack.add(treeNode1.left);
            tempStack.add(treeNode1.right);
        }
        return resultStack;
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
