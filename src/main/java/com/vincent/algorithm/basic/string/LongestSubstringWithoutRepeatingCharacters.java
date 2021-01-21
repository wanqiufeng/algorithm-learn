package com.vincent.algorithm.basic.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

/**
 * leetcode 3
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String test ="dvdf";
        int result = lengthOfLongestSubstring(test);
        System.out.println(result);
    }

    /**
     自己瞎写的，不是最优解：

     思路：
     1.使用一个hashMap，记录已经访问的字符和其对应小标
     2.当出现重复字符时，回退至第一次重复字符的下一个位置，重新计数，并清空Map
     3.这个过程中，始终有一个结果集，记录上述两个过程中，记录的最大值


     这理由个点，以dvdf为例
     第三个字符d重复了，我们不是从d的下一个字符串开始重新看不重复的数据
     而是，把第一个重复的字符去掉，从v开始，可以得出vdf的最优解

     */
    public static int lengthOfLongestSubstring(String s) {
        if(s==null ||s.length()==0) return 0;
        int resultLength = 0;
        HashMap<Character,Integer> cache = new HashMap<>();
        int count = 0;
        for(int i=0;i<s.length();) {
            char currentChar = s.charAt(i);
            if(cache.containsKey(currentChar)) {
                i = cache.get(currentChar)+1;
                cache.clear();
                count=0;
            } else {
                cache.put(currentChar,i);
                i++;
                count++;
            }
            resultLength = Math.max(resultLength,count);
        }
        return resultLength;
    }


}
