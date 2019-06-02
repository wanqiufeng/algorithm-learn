package com.vincent.algorithm.basic.sort;

/**
 * Created by chenjun on 19-6-2.
 */
public class BubbleSort {
    public static void main(String args[]) {
        Solution solution = new Solution();
        int[] nums=new int[]{5,4,3,2,1,9,6};
        solution.sortArray(nums);
        for(int i: nums){
            System.out.println(i);
        }
    }
    static class Solution {
        public int[] sortArray(int[] nums) {
            //一个内层循环，挨个交换相邻的两个元素，循环结束，一定能将最大的冒泡上去
            //加一个外层循环，是用来控制上述冒泡的次数。n个元素，要重复上述ｎ-1次操作
            //每一次内存循环，最大的循环次数，是数组长度，减去已经排序的次数，也即外层的index,因为外层循环的一个index变更，代表了一个元素已经排序好了
            for(int i = 0;i<nums.length-1;i++) {
                int cache;
                for(int j =0;j<nums.length-i;j++) {
                    if(j==nums.length-1){
                        break;
                    }
                    if(nums[j]>nums[j+1]) {
                        cache = nums[j+1];
                        nums[j+1] = nums[j];
                        nums[j] = cache;
                    }
                }
            }

            return nums;
        }
    }
}
