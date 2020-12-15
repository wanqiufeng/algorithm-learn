package com.vincent.algorithm.misc;

public class TwoNumberSum {
    public static void main(String[] args) {
        ListNode number1 = initNumber1();
        ListNode number2 = initNumber2();
        ListNode listNode = addTwoNumbers(number1, number2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    private static ListNode initNumber2() {
        ListNode listNode1 = new ListNode(5);
        ListNode listNode2 = new ListNode(6);
        ListNode listNode3 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        return listNode1;
    }

    private static ListNode initNumber1() {
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        return listNode1;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return dfs(l1, l2, 0);
    }

    static ListNode dfs(ListNode l, ListNode r, int i) {
        if (l == null && r == null && i == 0) return null;
        int sum = (l != null ? l.val : 0) + (r != null ? r.val : 0) + i;
        ListNode node = new ListNode(sum % 10);
        node.next = dfs(l != null ? l.next : null, r != null ? r.next : null, sum / 10);
        return node;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

}
