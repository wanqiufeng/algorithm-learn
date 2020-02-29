package com.vincent.algorithm.basic.linkedlist;

/**
 * Created by chenjun on 19-6-10.
 *
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class ReverseList {


    class Solution {
        /**
         *解题思路，一定要找到链表的最后一个元素，以倒序的方式翻转，才能保证关系不丢失。所以采用嵌套的方式，一层层最后的节点。翻转关系
         * 然后再逐级返回
         * 所有算法题，一定要学会拆解问题，找到最小的核心逻辑。
         */
        public ListNode reverseList(ListNode head) {
            if(head ==null|| head.next == null) {
                return head;
            }
            ListNode reverse = reverse(head, head.next);
            head.next = null;
            return reverse;
        }


        public ListNode reverse(ListNode parent,ListNode child) {
            if(child.next == null) {
                child.next = parent;
                return child;
            } else {
                ListNode next = child.next;
                child.next = parent;
                return reverse(child,next);
            }
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
