package com.vincent.algorithm.basic.linkedlist;

/**
 *
 *
 *给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 
 *
 * 示例：
 *
 * 给你这个链表：1->2->3->4->5
 *
 * 当k= 2 时，应当返回: 2->1->4->3->5
 *
 * 当k= 3 时，应当返回: 3->2->1->4->5
 *
 * 
 *
 * 说明：
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 */
public class ReverseNodesInKGroup {
    public static void main(String[] args) {

    }

    /**
     解题思路：
     1.先一个循环，尝试loop到指定k个元素的位置
     2.如果能loop到k，那么翻转链表，链表的的尾部，将是下一段链表翻转的头部（此处递归）
     3.
     * @return
     */
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
        if(count == k) { //这里一定要判断下，因为很可能上一步加加厚，currentNode已经变成Null了。但链表刚好K个长度，所以还是要翻转
            currentNode = reverseKGroup(currentNode,k);
            while (count-->0) {
                ListNode temp = head.next;
                head.next = currentNode;
                currentNode = head;
                head = temp;
            }
            head=currentNode;
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
