package com.vincent.algorithm.misc;


/**
 * 这个题有一个核心规律。第n步的总走法，等于第n-1步和n-2步的和
 * 而如果只有一步，那么它的走法为只有1
 * 如果有两部，那么它的走法为：1步，1步和 直接两步，两种走法
 */
public class ClimbStairs {
    public static void main(String[] args) {
        int i = climbStairs(7);
        System.out.println(i);
    }

    public static int climbStairs(int n) {
        if(n ==1) {
            return 1;
        }
        if(n == 2) return 2;
        return climbStairs(n-1) +climbStairs(n-2);
    }
}
