package com.vincent.algorithm.basic.btree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MidOrder {
    public static void main(String[] args) {

    }

    /**
     解题思路：
     1.依然用栈，因为访问只能从底层到底层，但实际存储数据是从底层开始。所以肯定要用栈记录从底层过程中路过的节点
     2.先从左边一路把对应的数据入栈。到左边没有的节点，如果其没有叶子节点了。那么从栈中弹出的元素就是我们需要访问的中序
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList();
        if(root == null) return result;
        LinkedList<TreeNode> stack = new LinkedList();
        while (root!=null || !stack.isEmpty()) {
            while (root!=null) {
                stack.push(root);
                root = root.left;
            }
            root= stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }
}
