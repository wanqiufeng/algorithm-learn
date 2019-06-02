package com.vincent.algorithm.basic.sort;

/**
 * Created by chenjun on 19-6-2.
 */
public class InsertSort {
    public static void main(String args[]) {
    Solution solution = new Solution();
    int[] nums=new int[]{6,1,2,3,4,5};
    solution.sortArray(nums);
    for(int i: nums){
        System.out.println(i);
    }
}
    static class Solution {
        /**插入排序是在已经位排序的队列中，拿一个元素，看其在有序队列中插入。
         * 比如对[1,2,3,4,5]做降序排列。两轮的顺序为：
         * 1,2,3,4,5
         * 2,1,3,4,5
         *
         * 其中2,1已经是有序的，剩下3,4,5还不是降序
         * 接下来，我们去3,看在有序队列中插入什么位置。
         * 这个算法的困难点是，我最开始以为，上来先跟有序队列中最大的比，如果３比它大，２，１先后往后挪动一格，即１占３的位置，２占１的位置。
         * 这样想就复杂了，因为想着一次找到正确的位置，然后来移动。
         * 实际上，我可以倒着来跟2,1队列比，只要比其中的大，就先交换。
         * 就相当于拿这剩下的元素，在有序队列中做冒泡。
         *
         * @param nums
         * @return
         */
        public int[] sortArray(int[] nums) {
            for(int i =0;i<nums.length;i++) {
                int value = nums[i];
                for(int j=i;j>=0;j--) {
                    if(value>nums[j]) {
                        nums[j+1] = nums[j];
                        nums[j] = value;
                    }
                }
            }
            return nums;
        }
    }
}
