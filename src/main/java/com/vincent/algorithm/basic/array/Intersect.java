package com.vincent.algorithm.basic.array;

import java.util.ArrayList;

/**
 * Created by chenjun on 19-6-2.
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class Intersect {
    public static void main(String args[]) {
        Solution solution = new Solution();
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};
        int[] intersect = solution.intersect(nums1, nums2);
        for(int i:intersect) {
            System.out.println(i);
        }
    }
    static class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            //循环数组１的每个元素，到数组２中挨个比较。
            //如果相等，则将结果纳入结果集，否则继续比较
            ArrayList<Integer> result = new ArrayList<>();
            for(int i = 0 ;i<nums1.length;i++) {
                for(int j = 0 ;j< nums2.length;j++) {
                    if(nums1[i] == nums2[j]) {
                        result.add(nums1[i]);
                    }
                }
            }
            return result.stream().mapToInt(i->i).toArray();
        }
    }
}
