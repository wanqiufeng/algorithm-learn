package com.vincent.algorithm.basic.array;

/**
 * 给定一个整数数组 nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释:连续子数组[4,-1,2,1] 的和最大，为6。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximumSubarray {
    public static void main(String[] args) {

    }

    /**
    这道题要找到是最大子序列的和，而不是最大子序列。所以我们不需要想办法存最大子序列，只需要存最大结果即可
    为此，我们设立一个result.

     初始result不能使0，而要是整形的最小值。因为数组中可能包含负数，如果跟result做大小判断，那么结果就将是0，这不正确，因为很可能数组全是负，最大子序列和就应该是负

     迭代数组，采用滑动窗口的思想。对一个当前滑动的结果和做累加，变量是presSum,
        如果上一步的累加已经小于等于0，说明这个窗口关闭。presum的值以当前值做基底重新累加
        如果上一步还大于0，则继续累加。

     这里面有个容易搞错的想法，如果按上述滑动思想，要是遇到数组[10,-1,-1,-1,-1] ，可以看到presum 每加一步，虽然没有小于等于0，但越来越小，反而最开始的[10]最大，但因为我们找的是
     最大合，而不是子数组，所以无所谓，因为最大和我们已经用了result做为存放。
     */
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int result = Integer.MIN_VALUE;
        int preSum = 0;
        for(int i=0;i<nums.length;i++) {
            if(preSum>0) {
                preSum += nums[i];
            } else {
                preSum = nums[i];
            }
            result = Math.max(preSum,result);
        }
        return result;
    }
}
