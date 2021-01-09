package com.vincent.algorithm.basic.array;

/**
 * Created by chenjun on 19-6-2.
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class PlusOne {
    public static void main(String args[]) {
        Solution solution = new Solution();
        int[] ar = new int[]{9};
        solution.plusOne(ar);
        for(int i:ar) {
            System.out.println(i);
        }
    }
    static class Solution {
        /**
         因为加1是从个位加起，而个位是数组的最后一个元素，所以倒着迭代数组
         如果某一位，加起来
            等于10
                将这一位置位0，continue for循环即可。
                为什么不需要进位的变量？
                    因为尝试加1 是for循环的第一段代码，如果上一段有进位，还会走for循环
                    如果没有进位，那么早就结束返回了
            不等于10，
                说明后续都不需要进位，对当前位做计算赋值后返回即可

         如果for 循环执行完毕后，依然没有返回，说明整个数组都进位了。那么久需要扩充数组。
         而都进位的场景，只有9999这种全是9的数据，对于这种数据，我们创建一个新数组，高位置1，连数组迁移都省了。

         */
        public int[] plusOne(int[] digits) {
            //从最后一个数循环起，加１，如果大于９，则进位加１
            for(int i=digits.length-1;i>=0;i--) {
                if(digits[i]+1 == 0) {
                    digits[i] = 0;
                } else {
                    digits[i] = digits[i]+1;
                    return digits;
                }

            }
            digits = new int[digits.length+1];
            digits[0]=1;
            return digits;
        }
    }
}
