package com.vincent.algorithm.basic.btree;

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

    }

    public List<Integer> traverse(TreeNode root) {
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

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
