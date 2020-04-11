package com.vincent.algorithm.basic.sort;

/**
 * Created by chenjun on 19-6-3.
 */
public class QuickSortV1 {

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
            quickSort(nums,0,nums.length-1);
            return nums;
        }

        private void quickSort(int[] nums, int start, int end) {
            //选一个基准值位置
            //从start开始，到end结束
            //比基准值大的保留，比基准值小的交换
            //记录基础值最后的位置。以基础值为分割点，拆分成两个队列，队列调用该方法


            if(start >= end) {
                return;
            }

            //从数组的第一个元素开始
            int baseIndex = start;

            //通过不停比较，将最小/最大的数据放到这里
            sortOnePartition(nums,baseIndex,end);

            //以下拆分成两个队列，依次也干这么个事情
            quickSort(nums,start,baseIndex-1);
            quickSort(nums,baseIndex+1,end);

        }

        private void sortOnePartition(int[] nums, int baseIndex, int end) {
            
            for(int i=baseIndex+1;i<=end;i++) {
                if(nums[i]>nums[baseIndex]) {
                    swap(nums,i,baseIndex);
                }
            }

        }

        private void swap(int[] nums, int start, int baseValueIndex) {
            int temp = nums[start];
            nums[start] = nums[baseValueIndex];
            nums[baseValueIndex]= temp;
        }


    }
}
