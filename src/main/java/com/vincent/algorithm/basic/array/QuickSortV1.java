package com.vincent.algorithm.basic.array;

/**
 * Created by chenjun on 19-6-3.
 */
public class QuickSortV1 {

    public static void main(String args[]) {
        Solution solution = new Solution();
        int[] nums = new int[]{5, 4, 3, 2, 1, 9, 6, 10};
        solution.sortArray(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }

    /**

     基准值baseValue，不光要找到，还需要有个位置先存放好。
     一般放当前分段的开始或末尾。等到找到基准值后，在跟这个末尾位置交换
     */
    static class Solution {

        public int[] sortArray(int[] nums) {
            quickSort(nums, 0, nums.length - 1);
            return nums;
        }

        private void quickSort(int[] nums, int start, int end) {
            if (start >= end) { //跳出条件一定要加
                return;
            }
            int baseIndex = (start + end) / 2; //这里选定基准位置
            int baseValue = nums[baseIndex];//取出对应的基准值
            swap(nums,baseIndex,end);//将基准值放置当前分段末尾
            int pointLeft = start;
            int pointRight = end;

            while (pointLeft < pointRight) {
                //注意这里一定是跟前面计算的好的基准值做判断，不要直接通过数组下标去定位基准值。因为交换过程中，基准值的位置会发生变化
                //也即，baseValue不要用nums[baseIndex]替代，切记，切记
                while (nums[pointLeft] <= baseValue && pointLeft < pointRight) {
                    pointLeft++;
                }
                while (nums[pointRight] >= baseValue && pointLeft < pointRight) {
                    pointRight--;
                }
                if (pointLeft < pointRight) {
                    swap(nums, pointLeft, pointRight);
                }
            }
            swap(nums,pointLeft,end);//走到这里，说明基于基准值比较的交换已经完成，当前pointLeft等于pointRight，且就是基准值应该呆的位置，这一步，实际是将基准归位，并将基准值当前位置的数据挪到尾部
            quickSort(nums, start, pointLeft - 1);
            quickSort(nums, pointLeft + 1, end);

        }


        private void swap(int[] nums, int start, int baseValueIndex) {
            int temp = nums[start];
            nums[start] = nums[baseValueIndex];
            nums[baseValueIndex] = temp;
        }
    }
}
