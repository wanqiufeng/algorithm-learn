package com.vincent.algorithm.basic.linkedlist;

import java.util.HashSet;
import java.util.Set;

/*
*存储前面遍历过的元素，依次来判断是否有重复
*
* */
public class RingLinkedListV1 {
    class Solution {
        public boolean hasCycle(ListNode head) {
            //使用一个set来存储遍历过的元素
            //看当前节点的下一个节点是否为空，或则为在set中存储
            //不存在则放入set中，并进入下次迭代
            Set<ListNode> iteratedSet = new HashSet<ListNode>();

            boolean hasCycle=false;
            ListNode next = head;
            while (next != null && next.next != null ) {
                if(iteratedSet.contains(next)) {
                    hasCycle = true;
                    break;
                }
                iteratedSet.add(next);
                next = next.next;
            }
            return hasCycle;
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
