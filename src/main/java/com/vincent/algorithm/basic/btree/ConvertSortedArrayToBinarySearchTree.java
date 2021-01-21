package com.vincent.algorithm.basic.btree;

/**
 * leetcode 108
 * 108. 将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class ConvertSortedArrayToBinarySearchTree {

    /**
     解题讲解：力扣官方

     解题思路：
     1.数组是有序的，且构建的二叉树要满足均衡，那么从数组中间构建构建根节点
     2.数组左侧天然小于根节点，即是其左子树
     3.数组左侧天然小于根节点，即是其右子树
     4.使用递归思想，再去分别构建起左子树和右子树即可
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode finalNode = build(nums,0,nums.length-1);
        return finalNode;
    }

    private TreeNode build(int[] nums, int start, int end) {
        if(start>end) return null;
        int mid = (start + end) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = build(nums,start,mid-1);
        treeNode.right = build(nums,mid+1,end);
        return treeNode;
    }
}
