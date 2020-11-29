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
public class MergeTwoListsV2 {
    public static void main(String[] args) {
        ListNode listNode1 = initListNode1();
        ListNode listNode2 = initListNode2();

        ListNode result = merge(listNode1,listNode2);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }


    }

    private static ListNode merge(ListNode listNode1, ListNode listNode2) {
        if(listNode1 == null ) {
            return listNode2;
        }
        if(listNode2 == null) {
            return listNode1;
        }

        while (listNode1 != null || listNode2 != null) {
            if(listNode1.val <= listNode2.val) {
                if(listNode1.next == null) {
                    listNode1.next = listNode2;
                    return listNode1;
                }
                if(listNode1.next.val <= listNode2.val) {
                    listNode1 = listNode1.next;
                } else {
                    listNode1.next = new ListNode(listNode2.val);
                    listNode2 = listNode2.next;
                }
            } else  {
                ListNode listNode = new ListNode(listNode2.val);
                listNode.next = listNode1;
                listNode2 = listNode2.next;
            }
        }
        return listNode1;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    private static ListNode initListNode1() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode4;
        return listNode1;
    }


    private static ListNode initListNode2() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode4;
        return listNode1;
    }
}
