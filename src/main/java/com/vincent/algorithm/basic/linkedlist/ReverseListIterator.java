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
public class ReverseListIterator {


    class Solution {
        /**
         *迭代的核心是双指针，引入一个pre 和head指针，相差刚好一步，一点点的往链表后面挪动。跟递归算法恰好相反，递归是达到链表的尾部。
         * 所以控制好pre和head两个指针就哈哈，一个代前一个指针，一个代表当前指针
         */
        public ListNode reverseList(ListNode head) {
            if(head ==null|| head.next == null) {
                return head;
            }
            ListNode pre = null;
           while (head != null) {
               ListNode temp = head.next;
               head.next = pre;
               pre = head;
               head = temp;
           }
           return pre;
        }



    }


    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head!=null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
