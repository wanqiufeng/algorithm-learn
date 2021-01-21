package com.vincent.algorithm.basic.stack;


import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 这个题是头条的面试题，要求使用队列模拟栈
 */
public class UseQueueAsStack {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }

    /**
     解题思路：
     1.队列的思想是先进先出，而栈的思想是先进后出
     2.如果是采用头插法维护的队列，那么每次pop应该就是取出队列的头部，考虑到队列如果从头部插入，那么只能从尾部取出。
     3。其思想就是，将队列中的元素按队列的方式，先出队列，然后再一次入队列，把原来的最新插入的元素推到对尾即可
     */
    public static class Stack {
        private LinkedList<Integer> queue;

        public Stack() {
            this.queue = new LinkedList<>();
        }

        public void push(Integer data) {
            queue.addFirst(data);
        }

        public Integer pop() {
            if(queue.isEmpty()) {
                return null;
            }
            int size = queue.size();
            for(int i=0;i<size;i++) {
                if(i==size-1) {
                    return queue.removeLast();
                }
                queue.addFirst(queue.removeLast());
            }
            return null;
        }
    }

}
