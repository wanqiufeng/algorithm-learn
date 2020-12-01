package com.vincent.algorithm.basic.sort;

/**
 * Created by chenjun on 2020-04-12 18:14
 */
public class MergeSortV2 {
    public static void main(String args[]) {
        int[] nums=new int[]{6,1,2,3,4,5};
        sort(nums);
        for(int i: nums){
            System.out.println(i);
        }
    }

    private static void sort(int[] nums) {
        sort(nums,0,nums.length -1);
    }

    private static void sort(int[] nums, int start, int end) {
        int range = end - start;
        if(range>1) {
            sort(nums, start, start + range / 2);
            sort(nums, (start + range / 2), end);
        } else {
            if(nums[start] > nums[end]) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
        }
    }

}
