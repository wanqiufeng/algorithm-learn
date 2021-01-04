package com.vincent.algorithm.basic.sort;

/**升序排列吧
 * Created by chenjun on 19-6-3.
 */
public class QuickSortV3 {

    public static void main(String args[]) {
        int[] nums = new int[]{5, 4, 3, 2, 1, 9, 6, 10};
        sort(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }

    private static void sort(int[] nums) {
        sort(nums,0,nums.length-1);
    }

    private static void sort(int[] nums, int start, int end) {
        if(start>end) {
            return;
        }
        int chooseIndex = (end+start)/2;
        int chooseValue = nums[chooseIndex];
        int leftStartIndex = start;
        int rightStartIndex = end;
        while(leftStartIndex<rightStartIndex) {
            while (leftStartIndex<rightStartIndex && nums[leftStartIndex] < chooseValue) {
                leftStartIndex++;
            }
            while (leftStartIndex<rightStartIndex && nums[rightStartIndex]> chooseValue) {
                rightStartIndex--;
            }
            if(leftStartIndex<rightStartIndex) {
                int temp = nums[rightStartIndex];
                nums[rightStartIndex] = nums[leftStartIndex];
                nums[leftStartIndex] = temp;
            }
        }
        nums[leftStartIndex] = chooseValue;
        sort(nums,0,leftStartIndex-1);
        sort(nums,leftStartIndex+1,end);
    }

}
