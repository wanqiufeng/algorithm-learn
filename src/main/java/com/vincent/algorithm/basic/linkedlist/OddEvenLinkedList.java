package com.vincent.algorithm.basic.linkedlist;

/**
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 *
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/odd-even-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OddEvenLinkedList {
    public static void main(String[] args) {

    }


    /**
        1.创建两个指针，第一个指针指向第一个节点，是为奇节点。第二个指针指向第一个节点的next,是为偶节点
        2.只要偶尔节点不为空，直接循环即可即可。因为偶节点的下一个节点就是奇节点，所以不需要双循环
        3.在循环中偶节点的下一个节点绑定到奇节点指针上，并完成奇指针的移动
        4.在循环中维护下偶节点的关联关系(即将偶节点的下一个节点指向奇节点的下一个节点)，并完成偶指针的移动
        5.如果循环完成，说明已经形成了两个链表，那么将偶链表直接挂到奇链表上即可。由于偶指针现在已经移动了偶链表的结尾，所以需要在程序开始存储一个偶链表的头节点，拥有引用整个链表
     */
    public ListNode oddEvenList(ListNode head) {
        if(head == null ||head.next == null) return head;
        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode evenHead = head.next;
        while (evenNode!=null && evenNode.next != null) {
            oddNode.next = evenNode.next;
            oddNode = oddNode.next;
            evenNode.next = oddNode.next;
            evenNode = evenNode.next;
        }
        oddNode.next = evenHead;
        return head;
    }
}
