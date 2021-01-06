package com.vincent.algorithm.basic.btree;

/**
 * 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class ValidateBinarySearchTree {
    public static void main(String[] args) {

    }

    /**
     很容易的，我们想到将节点的左右子树值，分别跟节点自己进行比较。这样有个问题
        1.节点的右子树值，虽然比节点值大。但是其右子树的的左子树的值，可能比当前节点的值小。也即，儿子满足你，孙子不满足。比如下面这个
     *     5
     *    / \
     *   1   7
     *      / \
     *     3   6
     *
     所以，一个节点的不光其直接节点要满足左小于，右大于的约定，其左子树的非直接节点，也要满足这个约束。
     所以，换一种思路，不拿当前节点和其左右子树比。而是对每个节点计算其取值范围，超过范围因为即不满足。
     那么这道题的题眼，就在于找每个节点的取值范围，从根节点开始。
     根节点的取值范围，当然是正无穷到负无穷


     一些问题：
        左子树的值，必须小于根节点。所以任何大于等于根节点的值，都是不合法的二叉树。但有个问题，由于我们的树的值是短整形int
        如果这个树就一个节点，且其值为整形的最大值,那么由于节点值等于了整形最大值，所以会返回false，这是不对的。

     解决办法：所以，我们将根节点限制范围初始值改成长整型的最大最小，然后将节点的值，转成长整型


     */
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MAX_VALUE,Long.MIN_VALUE);
    }

    public static boolean isValidBST(TreeNode root,Long maxValue,Long minValue){
        if(root == null) return true;
        Long currentValue = Long.valueOf(root.val);
        if(currentValue >= maxValue ||currentValue<=minValue) return false;
        return isValidBST(root.left,currentValue,minValue) && isValidBST(root.right,maxValue,currentValue);
    }
}
