package com.vincent.algorithm.basic.btree;

import java.util.ArrayList;
import java.util.List;

/**以下方式采用递归实现
 * Created by chenjun on 2020-04-11 15:16
 */
public class PostOrderBtreeRecursive {

    public static void main(String[] args) {

    }


    public List<Integer> traverse(TreeNode treeNode){
        List<Integer> result = new ArrayList<>();
        traverse(treeNode,result);
        return result;
    }

    private void traverse(TreeNode treeNode, List<Integer> result) {
        if(treeNode == null) {
            return;
        }
        traverse(treeNode.left,result);
        traverse(treeNode.right,result);
        result.add(treeNode.val);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
