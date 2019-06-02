package com.vincent.algorithm.basic.array;

import com.google.common.base.Preconditions;

/**
 * Created by chenjun on 19-6-2.
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class SingleNumber {
    public static void main(String args[]) {
        Solution solution = new Solution();
        int[] a = new int[] {4,1,2,1,2};
        int i = solution.singleNumber(a);
        Preconditions.checkArgument(i==4);
    }
    static class Solution {
        public int singleNumber(int[] nums) {
            //循环数组，拿到每个元素，在去跟数组中的每个元素挨个比较
            //找到相同的，则继续循环。
            //没知道相同的，则直接返回
            //怎么知道没知道找不到相同的？
            //除自己外，比较到最后一个元素，都不相等
            if(nums.length == 1) {
                return nums[0];
            }
            for(int i = 0;i<nums.length;i++) {
                for(int j = 0;j<nums.length;j++) {
                    if(i==j && j==nums.length-1) {
                        //两层循环都来到了最后一个元素，说明前面比较都没匹配。最后一个元素跟所有都不相等，直接返回
                        return nums[i];
                    }

                    if(i==j) {
                        //跳过跟自己的比较
                        continue;
                    }
                    //内层循环比较完，都没有找到相等，直接返回
                    if(nums[i]!=nums[j] && j == nums.length-1) {
                        return nums[i];
                    }
                    if(nums[i] == nums[j]) {
                        //普通相等，则直接跳出内层循环，进入下一个元素匹配
                        break;
                    }

                }
            }
            throw new NullPointerException();
        }
    }
}
