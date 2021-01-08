package com.vincent.algorithm.basic.array;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SingleNumber {
    public static void main(String[] args) {

    }

    /**
     用抑或运算。挨个将数组中的元素进行抑或。抑或运算的特点：
     1.任何数和 0 做异或运算，结果仍然是原来的数，即 a⊕0=a。
     2.任何数和其自身做异或运算，结果是 0，即 a⊕a=0。
     3.异或运算满足交换律和结合律，即 a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b。

     也即，其中成双成对的数字抑或后会变0，而0给单的那个数字抑或会保留那个数字。而抑或定律满足交换和结合定律，所以数组中数字的分布无论什么顺序都ok


     */
    public int singleNumber(int[] nums) {
        int orOperator = 0;
        for(int num:nums) {
            orOperator ^= num;
        }
        return orOperator;
    }
}
