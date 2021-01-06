package com.vincent.algorithm.jianzhioffer;

import java.util.*;

public class ValidParentheses {
    public static void main(String[] args) {
        String result = "([]";
        boolean valid = isValid(result);
        System.out.println(valid);
    }

    public static boolean isValid(String s) {
        if(s==null || s.length()==0) {
            return true;
        }
        Map<String, String> parentheMappings = new HashMap<>();
        parentheMappings.put(")","(");
        parentheMappings.put("]","[");
        parentheMappings.put("}","{");
        //将字符串切分
        //将右括号括号入栈
        //如果是左括号。则入栈
        //如果是右括号，则出栈一个，看其是否等于其反括号，如果等则下一个

        char[] chars = s.toCharArray();
        Set<String> rightKuohao = parentheMappings.keySet();
        Set<String> leftKuohao = new HashSet<>(parentheMappings.values());
        LinkedList<String> tempStack = new LinkedList();
        for(int i=0;i<chars.length;i++) {
            String currentKuohao =String.valueOf(chars[i]);
            if(rightKuohao.contains(currentKuohao)) {
                if(!parentheMappings.get(currentKuohao).equals(tempStack.pollFirst())) {
                    return false;
                }
            } else if(leftKuohao.contains(currentKuohao)) {
                tempStack.addFirst(currentKuohao);
            }
        }
        return tempStack.isEmpty();
    }
}
