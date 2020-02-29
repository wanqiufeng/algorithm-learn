package com.vincent.algorithm.basic.linkedlist;

/**
 * Created by chenjun on 19-6-10.
 * 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoLists {
    class Solution {
        /**
         *解题思路：新建一个链表，用于合并两个链表的数据。分别从两个链表中拿一个数据，将最小的节点，放入新链表。
         * 同时拿最小节点的下一个元素，同刚未被放进新链表的数据比较。循环往复
         * 直到启动一个链表的next节点已经变成空，那么直接将不空的链表拼接到新链表后面
         */
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if(l1 == null) return l2;
            if(l2 == null) return l1;

            ListNode pointerNode = new ListNode(-1);
            ListNode currentNode = pointerNode;
            while (l1 != null && l2 != null) {
                if(l1.val>l2.val ) {
                    currentNode.next = new ListNode(l2.val);
                    l2 = l2.next;
                } else {
                    currentNode.next = new ListNode(l1.val);
                    l1 = l1.next;
                }
                currentNode = currentNode.next;
            }

            if(l1 == null) {
                currentNode.next = l2;
            } else {
                currentNode.next = l1;
            }
            return pointerNode.next;
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
