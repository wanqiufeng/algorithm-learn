package com.vincent.algorithm.basic.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 * 
 *
 * 提示：
 *
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        threeSum(nums);
    }

    /**
        解题答案；极客时间的覃超，对这个问题有讲解
        解题思路：
        1.对数组按从小到大的顺序排序
        2.从0开始Loop结果集
        3.将数组分为还当前loop的变量，和剩余还未loop的数组两部分
        4.由于还未loop的剩余部分也是有序的。从还未loop的数组的两端各找一个变量，跟当前迭代变量相加，看是否等于0
        5.如果等于0返回，如果大于0，则将还未loop的数组右边的指针左移，由于数组是有序的，左移势必会减小三个数相加的结果
        6.反之，则将将未loop数组的左指针右移，
        7.如此循环

     */
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
