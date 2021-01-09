package com.vincent.algorithm.basic.linkedlist;

import java.util.List;

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
    public static void main(String[] args) {
        ListNode listNode = initListNode();
        ListNode result =  reverse(listNode);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    private static ListNode reverse(ListNode listNode) {
        if(listNode == null) {
            return null;
        }
        return  reverse(null, listNode);
    }

    private static ListNode reverse(ListNode parent, ListNode child) {
        if(child == null) {
            return parent;
        }
        ListNode next = child.next;
        child.next = parent;
        return reverse(child,next);
    }

    private static ListNode initListNode() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        return listNode1;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
