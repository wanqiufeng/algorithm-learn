package com.vincent.algorithm.basic.sort;

/**
 * Created by chenjun on 19-6-3.
 */
public class QuickSortV2 {

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
        if(start>=end) {
            return;
        }
        int range = (end - start)/2;
        int chooseOneValue = nums[start+range];
        int iterateStart = start;
        int iterateEnd = end;
        while (iterateStart<iterateEnd) {
            while (nums[iterateStart] <chooseOneValue && iterateStart < iterateEnd) {
                iterateStart ++ ;
            }
            while (nums[iterateEnd] >chooseOneValue && iterateStart <iterateEnd) {
                iterateEnd--;
            }
            if(iterateStart <iterateEnd) {
                int temp = nums[iterateStart];
                nums[iterateStart] = nums[iterateEnd];
                nums[iterateEnd] = temp;
            }
        }
        nums[iterateStart] = chooseOneValue;
        sort(nums,start,iterateStart-1);
        sort(nums,iterateStart+1,end);
    }

}
