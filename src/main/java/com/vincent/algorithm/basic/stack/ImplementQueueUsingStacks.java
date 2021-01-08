package com.vincent.algorithm.basic.stack;

import java.util.LinkedList;

/**
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列的支持的所有操作（push、pop、peek、empty）：
 *
 * 实现 MyQueue 类：
 *
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * 
 *
 * 说明：
 *
 * 你只能使用标准的栈操作 —— 也就是只有push to top,peek/pop from top,size, 和is empty操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 
 *
 * 进阶：
 *
 * 你能否实现每个操作均摊时间复杂度为 O(1) 的队列？换句话说，执行 n 个操作的总时间复杂度为 O(n) ，即使其中一个操作可能花费较长时间。
 * 
 *
 * 示例：
 *
 * 输入：
 * ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 1, 1, false]
 *
 * 解释：
 * MyQueue myQueue = new MyQueue();
 * myQueue.push(1); // queue is: [1]
 * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 * myQueue.peek(); // return 1
 * myQueue.pop(); // return 1, queue is [2]
 * myQueue.empty(); // return false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-queue-using-stacks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ImplementQueueUsingStacks {
    public static void main(String[] args) {

    }


    /**
     讲解视频：https://www.youtube.com/watch?v=G-xV4m6G2C8

     核心解法思想：
        栈是先进后出，为了实现先进先出，多用一个栈，将第一个栈中的数据倒腾过来，这样顺序就反了。
        比如，第一个栈入栈顺序是1<-2-<3 , 将这个栈中数据弹出来，放置到第二个栈，就变成了3<-2-<-1
        这样访问第二个栈的第一个元素就变成了1， 跟放入第一个栈的顺序就一致了

     总结下。插入用第一个栈，数据获取用第二个栈




     需要注意的是：
        1.第二个栈数据一定要清空后，再将第一个栈的数据全部倒腾过来。如果没清空就倒腾过来，会将一部分老数据压在下面，导致其最后才能被获取，从而破坏先进先出的特性
        2。但凡要迁移栈一的数据到栈二的数据，都需要全量数据一起迁移。如果迁移部分，那么会导致最先插入的数据，由于在栈1的底部没来得及迁移，这个时候去访问栈2的的数据将获取不到该数据的错误

        总结下，迁移时，一定要等栈2全为空，且一次要迁移完

     */
    public class MyQueue {
        LinkedList<Integer> stack1;
        LinkedList<Integer> stack2;
        /** Initialize your data structure here. */
        public MyQueue() {
            stack1 = new LinkedList<>();
            stack2 = new LinkedList<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stack1.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if(stack2.isEmpty()) {
                exchange();
            }
            return stack2.pop();
        }

        /** Get the front element. */
        public int peek() {
            if(stack2.isEmpty()) {
                exchange();
            }
            return stack2.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack1.isEmpty()&&stack2.isEmpty();
        }

        private void exchange() {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }
}
