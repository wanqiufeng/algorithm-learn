package com.vincent.algorithm.jianzhioffer;

public class ReverseLink {
    public static void main(String[] args) {

    }


    public static ListNode reverse(ListNode head){
        if(head == null ||head.next == null) return head;
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
