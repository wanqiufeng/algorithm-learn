package com.vincent.algorithm.basic.btree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PreOrder {
    /**
    结题思路。
     1.第一访问的把根节点的数据取出来，装到结果集
     2.第二访问的是左节点，把把指针指向左节点即可，那么左节点即为下一个根节点，这样左节点也是某种程度上的根节点
     3.第三访问的是右节点，但是我们要先把根节点（左节点）访问完毕，才能访问右节点，所以需要用一个东西把右子树先暂存
     4.用什么暂存呢？上层的右节点，要最后才能被访问，那肯定是通过栈了。
     5.当根节点，都访问完了，从栈中弹出数据，继续上述流程

     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList();
        if(root == null) return result;
        LinkedList<TreeNode> stack = new LinkedList();
        while (root != null) {
            result.add(root.val);
            if(root.right != null) {
                stack.addFirst(root.right);
            }
            if(root.left != null) {
                root = root.left;
            } else {
                root = stack.pollFirst();//如果左节点为空，说明已经打到地步，这个时候需要弹栈来访问右节点
            }
        }
        return result;
    }
}
