package com.vincent.algorithm.basic.string;

/**
 * 字符串翻转
 */
public class StringReverse {
    public static void main(String[] args) {
        //给定一个字符串，将其翻转
        String input = "hello world";
        //System.out.println(input);
        System.out.println(reverse(input));
    }

    public static String reverse(String string) {
        //用两个指针，分别指头尾，不停的交换
        if(string ==null || string.trim()== "") {
            throw new IllegalArgumentException("输出字符串不能为空");
        }
        char[] chars = string.toCharArray();
        for(int i=0,j=chars.length-1;i<j;i++,j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return String.valueOf(chars);
    }
}
