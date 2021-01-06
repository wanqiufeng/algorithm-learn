package com.vincent.algorithm.basic.linkedlist;


public class MergeTwoSortList {
    public static void main(String[] args) {

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 ==null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        ListNode firstNode = l1;
        ListNode secondNode = l2;
        ListNode result= new ListNode(-1);
        ListNode currentResultNode = result;
        while (firstNode != null || secondNode != null) {
            if(firstNode == null) {
                currentResultNode.next = secondNode;
                break;
            }
            if(secondNode == null) {
                currentResultNode.next = firstNode;
                break;
            }
            ListNode nextNode;
            if(firstNode.val >secondNode.val){
                nextNode = new ListNode(secondNode.val);
                secondNode = secondNode.next;
            } else {
                nextNode = new ListNode(firstNode.val);
                firstNode = firstNode.next;
            }
            currentResultNode.next = nextNode;
            currentResultNode = nextNode;
        }
        return result.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
