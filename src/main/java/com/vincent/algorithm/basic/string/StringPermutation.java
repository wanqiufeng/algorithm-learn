package com.vincent.algorithm.basic.string;

import java.util.*;

/**
 剑指 Offer 38. 字符串的排列
 输入一个字符串，打印出该字符串中字符的所有排列。



 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。



 示例:

 输入：s = "abc"
 输出：["abc","acb","bac","bca","cab","cba"]


 限制：

 1 <= s 的长度 <= 8
 *
 */
public class StringPermutation {
    public static void main(String[] args) {

    }

    /**
    实际上考察的是全排列的知识，需要用的回溯算法，跟leetcode 46题类似
    对应的视频：https://www.youtube.com/watch?v=w4SjNXKLsv4


     题的大概思路：
     1.整个数组的全排列实际上是一棵树
     2.我们只需要写代码，以深度优先的方式，遍历这颗树即可
     3.树的深度优先遍历，使用回溯算法即可
        以for循环的方式，取每个元素进一个路径，然后递归的去将其余的字符也以同样的方式for循环加入到路径中
        为了，保证下层循环不重复加已添加的路径，需要使用一个usedState 去存放已经访问的路径。比如abc ,我们已经把a放入path，递归就只能要求放入b和c

        另外一个就是回退
     */
    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        Set<String> resultList= new HashSet<>();
        int depth=0;
        LinkedList<Character> path = new LinkedList<>();
        boolean[] usedState = new boolean[chars.length];
        dfs(chars,resultList,path,usedState,depth);
        return resultList.toArray(new String[]{});
    }

    private void dfs(char[] chars, Set<String> resultList, LinkedList<Character> path, boolean[] usedState, int depth) {
        if(depth == chars.length) {
            //如果深度跟字符串的长度相同，说明已经到底了，将当前路径加入到结果集
            StringBuilder stringBuilder = new StringBuilder();
            for(Character s:path) {
                stringBuilder.append(s);
            }
            resultList.add(stringBuilder.toString());
        }
        for(int i = 0;i<chars.length;i++) {
            if(usedState[i]) continue;//这一步说明上层应遍历了这个节点，跳过，尝试看下一个字符的路径
            path.push(chars[i]);//这一步说明还没有走过节点，将其加入路径
            //并标记已经访问过,记录遍历下层
            usedState[i] = true;
            dfs(chars,resultList,path,usedState,depth+1);
            //以当前节点遍历的路径已走完。将其状态置成可访问，并回退，方便下一个节点的路径，可以使用当前节点
            usedState[i] = false;
            path.pop();
        }
    }
}
