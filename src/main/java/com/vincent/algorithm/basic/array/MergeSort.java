package com.vincent.algorithm.basic.array;

/**
 * Created by chenjun on 2020-04-12 18:14
 */
public class MergeSort {
    public static void main(String args[]) {
        Solution solution = new Solution();
        int[] nums=new int[]{6,1,2,3,4,5};
        solution.sortArray(nums);
        for(int i: nums){
            System.out.println(i);
        }
    }
    static class Solution {
        public int[] sortArray(int[] nums) {
            mergeSort(nums,0,nums.length-1);
            return nums;
        }

        private void mergeSort(int[] nums, int start, int end) {
            if(start>=end) {
                return;
            }
            int middleIndex = (start+end)/2;
            if((end-start)>1) {
                mergeSort(nums,start,middleIndex);
                mergeSort(nums,middleIndex+1,end);
            }
            merge(nums,start,middleIndex,end);
        }

        private void merge(int[] nums, int start, int middleIndex, int end) {
            int leftSize = middleIndex-start+1;
            int rightSize = end-middleIndex;
            int[] leftArray = new int[leftSize];
            int[] rightArray = new int[rightSize];


            //以下两个for循环，将员原来的数组，拆分成两个子数组
            for(int i=start;i<=middleIndex;i++){
                leftArray[i-start] = nums[i];
            }

            for(int i=middleIndex+1;i<=end;i++) {
                rightArray[i-(middleIndex+1)] = nums[i];
            }


            //注意这里需要三个指针，一个指向拆分后的数组1，一个指向拆分后的数组2. 另一个指向原数组
            int leftIndex=0;
            int rightIndex=0;
            int totalIndex = start;

            //迭代两个小数组，将其中较小的那个数组的值放到原来的大数组中，并累加该小数组的指针，和原理大数组的指针
            while (leftIndex<leftSize && rightIndex<rightSize) {
                if(leftArray[leftIndex] > rightArray[rightIndex]) {
                    nums[totalIndex] = rightArray[rightIndex];
                    rightIndex++;
                } else {
                    nums[totalIndex] = leftArray[leftIndex];
                    leftIndex++;
                }
                totalIndex++;
            }

            //如果左边的小数组还没迭代完，则将后续节点直接插入大数组中
            while (leftIndex<leftSize) {
                nums[totalIndex] = leftArray[leftIndex];
                totalIndex++;
                leftIndex++;
            }

            //如果右边的小数组还没迭代完，则将后续节点直接插入大数组中
            while (rightIndex<rightSize) {
                nums[totalIndex] = rightArray[rightIndex];
                totalIndex++;
                rightIndex++;
            }
        }
    }
}
