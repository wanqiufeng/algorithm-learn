package com.vincent.algorithm.basic.array;

/**
 * Created by chenjun on 19-6-2.
 */
public class SelectSort {
    public static void main(String args[]) {
        Solution solution = new Solution();
        int[] a = new int[]{8,9,3,1,2};
        solution.sortArray(a);
        for(int i:a) {
            System.out.println(i);
        }
    }
    static class Solution {
        //选择排序跟冒泡排序类似，都是两两比较找出最大
        //冒泡排序是两两比较找出大值后，不断交换。把最大的冒泡上去
        //选择排序则是两两比较，并不交换，一直找到最大的值后，再做交换。
        public int[] sortArray(int[] nums) {
            for(int j=0;j<nums.length;j++) {
                int maxIndex = j;
                for(int i=0;i<nums.length-j;i++) {
                    if(i==j) {
                        continue;
                    }
                    if(nums[i] > nums[maxIndex]) {
                        maxIndex = i;
                    }
                }
                int cache;
                cache = nums[nums.length-1-j];
                nums[nums.length-1-j] = nums[maxIndex];
                nums[maxIndex] = cache;
            }
            return nums;
        }
    }
}
