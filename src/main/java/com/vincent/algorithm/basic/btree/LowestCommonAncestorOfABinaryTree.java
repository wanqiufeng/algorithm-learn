package com.vincent.algorithm.basic.btree;

/**
 * leetcode 236
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树: root =[3,5,1,6,2,0,8,null,null,7,4]
 *
 *
 *
 * 
 *
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例2:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 * 
 *
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LowestCommonAncestorOfABinaryTree {

    /**
     视频讲解：见极客时间,覃超

     最大公共子树定义：就是看两个节点，从它开始往根回溯过程中的两条路径中，最早相遇的点
     解题思路：使用递归
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null|| root.equals(p) || root.equals(q)) return root;//如果输入的节点为空直接返回。如果要查找的节点任意一个等于根节点，那么最大公共子树就是根节点。因为根节点是所有子节点的共同节点。
        TreeNode leftTreeNode = lowestCommonAncestor(root.left, p, q);//如果上述p或q不是根节点，那么递归去左子树中找
        TreeNode rightTreeNode = lowestCommonAncestor(root.right, p, q);//如果上述p或q不是根节点，那么递归去右子树中找
        if(leftTreeNode == null) {
            //如果左子中找的结果为空，说明p和q 都不在左子树。所以直接使用右子树遍历的结果即可
            return rightTreeNode;
        }
        if(rightTreeNode == null) {
            //如果右子树查找的结果为空，说明p，q都不在右子树，而在左子树。 所以直接使用左子树搜索的结果即可
            return leftTreeNode;
        }

        //如果左右搜索的结果都不为空，说明p和q，分别分布在左右子树中。那么当前的root显然就应该是他们的公共子节点
        return root;
    }
}
