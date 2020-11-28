package com.vincent.algorithm.basic.linkedlist;

/**
 * Created by chenjun on 19-6-3.
 * <p>
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 * <p>
 * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
 * <p>
 * 4---->5---->1---->9
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: head = [4,5,1,9], node = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 * <p>
 * 输入: head = [4,5,1,9], node = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 * <p>
 * <p>
 * 说明:
 * <p>
 * 链表至少包含两个节点。
 * 链表中所有节点的值都是唯一的。
 * 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
 * 不要从你的函数中返回任何结果。
 */
public class DeleteNode {
    public static void main(String[] args) {
        ListNode listNode = initListNode();
        deleteSpecificNode(listNode, 3);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    private static void deleteSpecificNode(ListNode listNode, int i) {
        if(listNode == null) {
            return;
        }

        //如果要删除的数据，刚好是链表的第一个元素，那么需要将第一个元素的值改为其next，然后删除其next即可
        if(listNode.val == i) {
            listNode.val = listNode.next.val;
            listNode.next = listNode.next.next;
            return;
        }

        //其余的删除只需要找到该元素所的位置，然后完成其前和其后的两个元素绑定即可
        while (listNode.next != null) {
            if(listNode.next.val == i) {
                listNode.next = listNode.next.next;
                break;
            }
            listNode = listNode.next;
        }
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

    class Solution {
        public void deleteNode(ListNode node) {
            ListNode after = node.next;

        }
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
