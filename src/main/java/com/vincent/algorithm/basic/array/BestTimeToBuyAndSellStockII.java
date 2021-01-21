package com.vincent.algorithm.basic.array;

import com.google.common.base.Preconditions;

/** leetcode 122
 * Created by chenjun on 19-6-1.
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 */
public class BestTimeToBuyAndSellStockII {
    public static void main(String args[]) {
        int prices[] = new int[]{7,1,5,3,6,4};
        Solution solution = new Solution();
        int i = solution.maxProfit(prices);
        Preconditions.checkArgument(i==7);
    }

    //该题暗含的意思是当天卖出，当天即可买入
    //以最小模型三天看，买股票有两种方案，
    //１.第一天买入，第二天卖出再买入，第三天卖出
    //2.第一天买入，第三天卖出
    //这两种方案收益其实是一样的，数学推导如下：
    //第一天价格为A,第二天价格为B,第三天为C
    //那么第一种方案的收益为：B-A + C-B = C-A
    //所以某一天买入后，具体哪天卖出其实可以简化为头天买入，第二天卖出的模型。
    //我们基于两两差值，找出那些收益为正的求和，即得到最大收益
    static class Solution {
        public int maxProfit(int[] prices) {
            int max = 0;
            for(int i=0;i<prices.length-1;i++) {
                int profit = prices[i + 1] - prices[i];
                if(profit >0) {
                    max += profit;
                }
            }
            return max;
        }
    }
}
