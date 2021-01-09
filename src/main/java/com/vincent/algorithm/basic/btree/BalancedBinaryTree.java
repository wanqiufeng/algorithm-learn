package com.vincent.algorithm.basic.btree;

/**
 *给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1 。
 *
 * 
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 * 示例 3：
 *
 * 输入：root = []
 * 输出：true
 * 
 *
 * 提示：
 *
 * 树中的节点数在范围 [0, 5000] 内
 * -104 <= Node.val <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BalancedBinaryTree {
    public static void main(String[] args) {

    }

    /**
     视频资料：https://www.youtube.com/watch?v=C75oWiy0bWM

     1.采用递归的方式，当前节点的左右子树是否相差1。
     2.并递归检查左右节点各自的子树，是否平衡，之所以这样做，是因为当前节点平衡，但其子树可能不平衡。
     3.左右子树的高度，也采用递归计算

     高度计算的逻辑：
        取左右子树高度最大的值加1. 因为当前节点的高度，应该包含自己

     */
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return Math.abs(height(root.left)-height(root.right)) <=1  && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode node) {
        if(node == null) return 0;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return Math.max(leftHeight,rightHeight)+1;
    }
}
