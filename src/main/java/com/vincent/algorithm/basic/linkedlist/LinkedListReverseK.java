package com.vincent.algorithm.basic.linkedlist;

public class LinkedListReverseK {
    public static void main(String[] args) {

    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head ==null || head.next == null || k == 0) {
            return head;
        }
        int count = 0;
        ListNode currentNode = head;
        while (count !=k &&currentNode != null) {
            currentNode = currentNode.next;
            count++;
        }
        if(count == k) {
            currentNode = reverseKGroup(currentNode,k);
            while (count-->0) {
                ListNode temp = head.next;
                head.next = currentNode;
                currentNode = head;
                head = temp;
            }
            head= currentNode;
        }
        return head;
    }



    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
