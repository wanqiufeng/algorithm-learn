package com.vincent.algorithm.jianzhioffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        threeSum(nums);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            int j = i+1;
            int k = nums.length-1;
            while (j<k && j<nums.length ) {
                int sum = nums[i] + nums[k] + nums[j];
                if(sum == 0) {
                    List<Integer> tempResult = new ArrayList();
                    tempResult.add(nums[i]);
                    tempResult.add(nums[j]);
                    tempResult.add(nums[k]);
                    result.add(tempResult);
                    break;
                }
                else if(sum>0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return result;
    }


}
