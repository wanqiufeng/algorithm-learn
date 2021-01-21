package com.vincent.algorithm.basic.array;

/**
 * 33. 搜索旋转排序数组
 * 升序排列的整数数组 nums 在预先未知的某个点上进行了旋转（例如， [0,1,2,4,5,6,7] 经旋转后可能变为 [4,5,6,7,0,1,2] ）。
 *
 * 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：nums = [1], target = 0
 * 输出：-1
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * nums 中的每个值都 独一无二
 * nums 肯定会在某个点上旋转
 * -10^4 <= target <= 10^4
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while (start<=end) {
            int mid = (start+end)/2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid]<target) {
                //如果目标值比中间值小，那么目标值可能在右边
                if(nums[mid]<=nums[end] && target<=nums[end]) {
                    //且中间值比结束值小，说明右边有序，按普通二分查找即可
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            } else {
                if(nums[start]<=nums[mid] && target>=nums[start]) {
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            }
        }
        return -1;
    }
}
