package com.vincent.algorithm.basic.array;

/**
 * Created by chenjun on 19-6-2.
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class MoveZeroes {

    public static void main(String args[]) {
        Solution solution = new Solution();
        int[] a = new int[]{0,1,0,3,12};
        solution.moveZeroes(a);
        for(int i:a) {
            System.out.println(i);
        }
    }
    static class Solution {
        public void moveZeroes(int[] nums) {
            //外层循环，遍历每一个元素，跟其前面的元素比，如果为０，则交换，否则停止
            for(int i = 1;i<nums.length;i++) {
                if(nums[i] == 0) {
                    continue;
                }
                for(int j = i-1;j>=0;j--) {
                    if(j == 0 && nums[j] == 0) {
                        nums[j] = nums[i];
                        nums[i]=0;
                    } else if(nums[j] ==0 && nums[j-1] != 0) {
                        nums[j] = nums[i];
                        nums[i]=0;
                    }
                }

            }
        }
    }
}
