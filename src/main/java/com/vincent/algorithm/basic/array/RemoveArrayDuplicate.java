package com.vincent.algorithm.basic.array;

/**
 * Created by chenjun on 19-3-12.
 *
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 *
 * 给定数组 nums = [1,1,2],
 *
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveArrayDuplicate {
    public static void main(String args[]) {
        Solution solution = new Solution();
        int[] a = new int[]{1,1,5,6,7,7,9};
        int i = solution.removeDuplicates(a);

    }

    static class Solution {
        //思路，虽然数组只能是一个，但是我们可以通过两个指针指向该数组，使得我们仿佛有两个数组。
        //这两个指针可以分开遍历，操作数组的值
        //设两个指针i,和j
        //指针i属于慢指针，主要负责修改该数据的值
        //指针j属于快指针，主要循环拿到数组的值去给慢指针指向的元素比较
        //如果j指向的值同i指向的值相等，则ｉ指向的数组不做任何处理，否则将ｊ指向的值赋值给i指向的下一个值
        public int removeDuplicates(int[] nums) {
            int i = 0;
            for(int j = 0;j<nums.length;j++) {
                if(nums[i]!=nums[j]) {
                    nums[i+1] = nums[j];
                    i++;
                }
            }
            return i+1;
        }
    }
}
