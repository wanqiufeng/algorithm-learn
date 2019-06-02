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
        public int[] plusOne(int[] digits) {
            //从最后一个数循环起，加１，如果大于９，则进位加１
            for(int i=digits.length-1;i>=0;i--) {
                if(digits[i]+1==10) {
                    digits[i] = 0;
                    continue;
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
