package com.vincent.algorithm.basic.linkedlist;

/*
*使用双指针。慢指针步长小于快指针。快指针先执行，只要存在环。快指针一定能在下一次环中赶上慢指针(也即快指针的节点等于慢指针的节点)，想想操场
*
* */
public class RingLinkedListV2 {
    class Solution {
        public boolean hasCycle(ListNode head) {
            ListNode slowPointer = head;
            ListNode fastPointer;
            if(head != null && head.next != null) {
                fastPointer = head.next;
            } else {
                return false;
            }

            while (slowPointer != null && fastPointer != null) {
                if(slowPointer.equals(fastPointer)) {
                    return true;
                }

                if(fastPointer.next!=null && fastPointer.next.next!=null) {
                    fastPointer = fastPointer.next.next;
                }
                slowPointer = slowPointer.next;
            }

            return false;
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
