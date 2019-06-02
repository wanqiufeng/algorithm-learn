package com.vincent.algorithm.basic.array;

import com.google.common.base.Preconditions;

/**
 * Created by chenjun on 19-6-2.
 *
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */
public class ContainsDuplicate {
    public static void main(String args[]) {
        Solution solution = new Solution();
        int[] array = new int[]{1,1,1,3,3,4,3,2,4,2};
        boolean b = solution.containsDuplicate(array);
        Preconditions.checkArgument(b);
    }
    static class Solution {
        public boolean containsDuplicate(int[] nums) {
            //依次循环数组，去跟剩下的元素比较。如果相同，返回true
            for(int i = 0;i<nums.length-1;i++) {
                for(int j = i+1;j<nums.length;j++) {
                    if(nums[i] == nums[j]) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
