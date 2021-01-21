package com.vincent.algorithm.basic.stack;

import java.util.LinkedList;

/**
 * leetcode没有公开这个题。题意大概是提供实现一个stack,实现一个具有普通栈功能之外，还能需要提供获取栈中最大数据的方法
 * 具体题描述见：https://www.cnblogs.com/grandyang/p/7823424.html
 */
public class MaxStack {
    public static void main(String[] args) {

    }


    /**

     视频资料：https://www.youtube.com/watch?v=y7T00suWkrY

     核心思路：
        1.使用两个栈，一个栈提供普通的栈的功能，另外一个栈用于存放最大值。
        2.存放最大值的栈入栈的特点是，将入栈元素跟栈顶元素比较，将最大的那个入栈，比如栈顶是5，我们现在常规入栈是3，那么我们就需要再在最大栈中入一个5
        3.出栈是，从普通栈和最大栈中分别弹出一个数据，最大站弹出的肯定是最大值，但常规栈弹出的不一定，所以需要有比较操作。如果常规栈不是最大，那么先暂存，找到最大的弹出，把之前最小的再依次放回。相当于重复上两部的动作
            对于常规栈中弹出的不是最大的值得数据，我们还可以用第三个栈做保存。

     */
    public class Stack {
        LinkedList<Integer> regularStack;
        LinkedList<Integer> maxStack;
        public Stack(){
            regularStack = new LinkedList();
            maxStack = new LinkedList<>();
        }
        void push(int x) {
            regularStack.push(x);
            int maxValue = Math.max(maxStack.peek(),x);
            maxStack.push(maxValue);
        }

        int pop() {
            Integer pop = regularStack.pop();
            //因为栈2中的最大值可能重复，所以这里需要循环弹出比较
            while (maxStack.peek() == pop) {
                maxStack.pop();
            }
            return pop;
        }

        int peek() {
            return regularStack.peek();
        }

        int peekMax() {
            return maxStack.pop();
        }

        int popMax() {
            Integer data = maxStack.pop();
            LinkedList<Integer> tempStack = new LinkedList<>();

            while (regularStack.peek() !=  data) {
                //如果常规栈中的值不等于最大值，那么将该值弹出压入临时栈
                tempStack.push(regularStack.pop());
            }
            regularStack.pop();//走到这一步，说明已经找到了跟max栈中相等的元素
            while (!tempStack.isEmpty()) {
                //将临时栈中的数据回填至这整个数据结构
                push(tempStack.pop());
            }
            return data;
        }
    }


}
