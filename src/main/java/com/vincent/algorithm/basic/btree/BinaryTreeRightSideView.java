package com.vincent.algorithm.basic.btree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 199. 二叉树的右视图
 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

 示例:

 输入: [1,2,3,null,5,null,4]
 输出: [1, 3, 4]
 解释:

 1            <---
 /   \
 2     3         <---
 \     \
 5     4       <---
 */
public class BinaryTreeRightSideView {
    /**
     题解视频：
        1.leetcode官方的广度优先的算法就已经能够很好的解决问题
     题意理解：
        1.右视图，就是从右边去看二叉树的的一个状态，注意仅仅是从根节点开始，一路去拿右节点做为结果集，并不是正确的解题思路
        因为，有可能这颗树，只有左节点，没有右节点。那从右边依然能看到一系列的节点
     解题思路：
        1.采用广度优先的算法，从左至右找到每一层的最后一个节点，将其值加入结果集
        2.然后再遍历下一层的，按上述同样的方法执行
        3.首先我们需要有一个东西，把某一层从左至右的节点全部存起来。其思路就是，使用队列

     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        LinkedList<TreeNode> queue = new LinkedList<>(); //队列来按从左至右的顺序存放某一层的节点。下面采用按在队列头插入，队列尾取出的方式，实现队列的先进先出特性
        queue.addFirst(root);
        while (!queue.isEmpty()) { //一层访问完了，只要队列不为空，就进行下一层的访问
            int queueSize = queue.size();//此时队列中装了完整的一层
            for(int i=0;i<queueSize;i++) { //这里需要基于size去控制循环的次数原因是：循环过程中，为了节约存储空间，又在队列的头部，插入下层的所有节点(本层老节点在队列尾部)
                TreeNode treeNode = queue.removeLast();//从队列尾部取出一个节点，
                if(i == queueSize-1) {//发现它已经是本层的最后一个节点，就把其值放入结果
                    result.add(treeNode.val);
                }

                //下面是看如果某个节点的左右子树不为空，那按从左至右的顺序，将其下层入队列
                if(treeNode.left!=null) {
                    queue.addFirst(treeNode.left);
                }
                if(treeNode.right != null) {
                    queue.addFirst(treeNode.right);
                }
            }
        }
        return result;
    }
}
