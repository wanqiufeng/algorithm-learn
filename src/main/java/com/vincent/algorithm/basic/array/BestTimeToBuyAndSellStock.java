package com.vincent.algorithm.basic.array;

/**
 * leetcode 121
 * 121. 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class BestTimeToBuyAndSellStock {


    /**
     解题讲解：力扣官方
     题意：
        就是只能进行一次股票的买入和卖出。能够获得的最大利润是多少
        都要先买菜能卖
     解题思路：
        1.要想利益最大化，肯定是低点买入，高点卖出
        2.一次循环过程中，找到最小的值，并基于此对其进行卖出计算，有一个变量存储最大的差值即可
     */
    public int maxProfit(int[] prices) {
        int minValue = Integer.MAX_VALUE;//这里一定是最大值，如果设为0，那很可能数组中，本身就没有0的元素，那最小值始终是0，而不是数组的最小值
        int maxProfit = 0;
        for(int i=0;i<prices.length;i++) {
            minValue = Math.min(minValue,prices[i]);
            int todaySaleProfit = prices[i] - minValue;
            maxProfit = Math.max(maxProfit,todaySaleProfit);
        }
        return maxProfit;
    }
}
