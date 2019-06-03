package com.vincent.algorithm.basic.sort;

/**
 * Created by chenjun on 19-6-3.
 */
public class QuickSort {

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

        public void quickSort(int[] nums,int start,int end) {
            if(start>=end) {
                return;
            }
            int baseValue = nums[(start+end)/2];//找到一个基数，这里直接找中间这个数
            //将整个基数两边，看成两个队列，分别用两个指针。左指针指向开始，右指针指向结束
            int head = start;
            int tail = end;


            //将所有存在左小于基准的数值，和右小于基准的数值交换。直到找不到可换的位置
            while(head<=tail) {
                while (nums[head]>baseValue) {
                    head++;
                }
                while (nums[tail]<baseValue) {
                    tail--;
                }

                if(head<tail) {
                    int cache = nums[head];
                    nums[head] = nums[tail];
                    nums[tail] = cache;
                }

                if(head == tail) {
                    //这里加１是为了跳出循环
                    head++;
                }
            }
            quickSort(nums,start,tail);//递归左边
            quickSort(nums,head,end);//递归右边
        }
    }
}
