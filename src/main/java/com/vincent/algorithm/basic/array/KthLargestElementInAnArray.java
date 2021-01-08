package com.vincent.algorithm.basic.array;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        int[] array = {3,2,3,1,2,4,5,5,6};
        KthLargestElementInAnArray kthLargestElementInAnArray = new KthLargestElementInAnArray();
        int kthLargest = kthLargestElementInAnArray.findKthLargest(array, 4);
        System.out.println(kthLargest);
    }


    /**
     审题；

     视频讲解：
         https://www.youtube.com/watch?v=ow04KXJ0kG4
         https://www.youtube.com/watch?v=zOmIKYKpzB4


     题意：
        其实要找数组中第k大的元素，并且不是绝对意义上的第k大，而是包含重复数据的第四大。比如4,4,3,2 第2大元素是4，并不是3
        说白了，对数组按从大到小的方式排序，然后数对应的小标即可。

        而快速排序的效率较高，我们利用快速排序能快速对一个值归为到其应该所在位置的特性，使用快速排序。
        且不需要对将数据排完，只要排序过程中，排序的位置等于我们想找得k-1位置，那么即返回
     */
    public int findKthLargest(int[] nums, int k) {
        if(nums == null ||nums.length == 0 ) return 0;
        int start = 0;
        int end = nums.length-1;
        int findIndex = k-1;
        findKthLargest(nums,start,end,findIndex);
        return nums[findIndex];
    }

    private void findKthLargest(int[] nums, int start, int end, int findIndex) {
        if(start>=end) {
            return;
        }
        int startIndex = start;
        int endIndex = end;
        int chooseIndex = (start+end)/2;
        int chooseData = nums[(start+end)/2];
        swap(nums,chooseIndex,endIndex);
        while (startIndex<endIndex) {
            while (startIndex<endIndex && nums[startIndex]>= chooseData) {
                startIndex++;
            }
            while (startIndex<endIndex && nums[endIndex] <=chooseData) {
                endIndex--;
            }
            if(startIndex<endIndex) {
                swap(nums,startIndex,endIndex);
            }
        }
        swap(nums,startIndex,end);
        if(startIndex == findIndex) {
            //如果当前排好顺序的位置，刚好是我们要找的位置，那么直接返回，不用后续的排序了
            return;
        }
        if(startIndex>findIndex) {
            //如果当前排好的位置，比我们要找的位置大，说明我们要找的位置，在当前排好位置的左边，我们只排左边即可
            findKthLargest(nums,start,startIndex-1,findIndex);
        } else {
            //如果当前排好的位置，比我们要找的位置小，说明我们要找的位置，在当前排好位置的右边，我们只排左边即可
            findKthLargest(nums,startIndex+1,end,findIndex);
        }
    }

    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
