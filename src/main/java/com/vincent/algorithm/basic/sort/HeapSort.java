package com.vincent.algorithm.basic.sort;

/**
 * Created by chenjun on 2020-04-12 14:24
 */
public class HeapSort {

    public static void main(String args[]) {
        Solution solution = new Solution();
        int[] nums = new int[]{5, 4, 3, 2, 1, 9, 6, 10};
        solution.sortArray(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }

    static class Solution {

        public int[] sortArray(int[] nums) {
            initHeap(nums);
            for(int i =0;i<nums.length;i++) {
                int currentSortIndex = nums.length - 1 - i;
                swap(nums,0, currentSortIndex);//鉴于进入该方法时，已排好了堆。那么将当前堆顶元素，放入数组后面即可
                heapify(nums,0,currentSortIndex-1);//上面置换后，重新堆化剩下的数据
            }
            return nums;
        }

        private void initHeap(int[] nums) {
            int lastIndex = nums.length-1;
            int lastTreeParent = (lastIndex-1)/2;
            for(int i = lastTreeParent;i>=0;i--) {
                heapify(nums,i,lastIndex);
            }
        }


        private void swap(int[] nums, int index1, int index2) {
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }

        private void heapify(int[] nums, int start, int end) {
            if(start>=end) {
                return;
            }
            int leftChildIndex = start*2+1;
            int rightChildIndex = start*2+2;
            int maxIndex = start;
            if(leftChildIndex <= end && nums[leftChildIndex]>nums[maxIndex]) {
                maxIndex = leftChildIndex;
            }
            if(rightChildIndex <= end && nums[rightChildIndex]>nums[maxIndex]) {
                maxIndex = rightChildIndex;
            }

            if(start != maxIndex) {
                swap(nums,start,maxIndex);
                //heapify的逻辑是建立在整颗二叉树只有当前节点对应的三个节点不是堆的前提下。所以这里值需要递归调对顶有
                //改变的子树即可，没动的子树说明还是堆
                heapify(nums,maxIndex,end);
            }
        }
    }
}
