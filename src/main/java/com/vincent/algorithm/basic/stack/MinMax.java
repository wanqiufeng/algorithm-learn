package com.vincent.algorithm.basic.stack;

import java.util.LinkedList;

/**
 * leetcode 155
 * 155. 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 *
 * 示例:
 *
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 *
 * 提示：
 *
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 */
public class MinMax {

    /**
     * 解题思路给最大栈一样
     * 用两个栈。一个栈普通栈，按栈的行为存放数据
     * 另外一个最小站，只往栈顶存放当前最小值，这样每次从该栈pop时，总是最小值
     */
    class MinStack {
        LinkedList<Integer> normalStack;
        LinkedList<Integer> minStack;

        /** initialize your data structure here. */
        public MinStack() {
            normalStack = new LinkedList<>();
            minStack = new LinkedList<>();
        }

        public void push(int x) {
            normalStack.push(x);
            Integer currentMinNode = minStack.peek();
            int currentMinValue = currentMinNode == null?Integer.MAX_VALUE:currentMinNode;
            int min = Math.min(x, currentMinValue);
            minStack.push(min);
        }

        public void pop() {
            normalStack.pop();
            minStack.pop();
        }

        public int top() {
            return normalStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

}
