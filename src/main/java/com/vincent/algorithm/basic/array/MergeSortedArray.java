package com.vincent.algorithm.basic.array;

/**
 * leetcode 88
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 有足够的空间（空间大小等于 m + n）来保存 nums2 中的元素。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 示例 2：
 *
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 *
 *
 * 提示：
 *
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * nums1.length == m + n
 * nums2.length == n
 * -109 <= nums1[i], nums2[i] <= 109
 */
public class MergeSortedArray {
    /**
    解题讲解：leetcode官方

     题意理解：
        m是指nums1中包含有效元素的长度，比如nums1的值为1,2,3,0,0 。那么m是3

     解题思路：
        1.由于两个数组都是有序的。并且nums1的长度包含nums2的长度，那么从能存下m和n个元素的末尾，开始存放数据

     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;//nums1最后一个有效元素的位置
        int j = n-1;//nums2最后一个有效元素的位置
        int f = m+n-1;//最终结果集
        while (i>=0 && j>=0) {
            //下面这段逻辑，其实就是在比较大小。将较大的数字按序放置到nums1的末尾
            boolean nums1GTnums2 = nums1[i]>nums2[j];
            if(nums1GTnums2) {
                nums1[f] = nums1[i];//把原来i位置的数据，放置到f位置，为什么不用清楚原来i位置的数据？因为数据是有序的。另外数组的元素，最终会覆盖i位置的数据。当然不放心，也可以清空
                i--;
            } else {
                nums1[f] = nums2[j];
                j--;
            }
            f--;
        }
        if(i<0) {
            //如果数组1走完了，数组2还没走完。那么说明数组1已经全部按序放置到结果集中了。要做的是把剩下nums2 没处理的数据，从下标0开始，复制到结果集中就好
            System.arraycopy(nums2,0,nums1,0,j+1);
        }
    }
}
