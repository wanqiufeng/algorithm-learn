package com.vincent.algorithm.basic.linkedlist;

/**
 * 给定一个头结点为 head的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * 示例2：
 *
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 * 
 *
 * 提示：
 *
 * 给定链表的结点数介于1和100之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/middle-of-the-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MiddleOfTheLinkedList {
    public static void main(String[] args) {

    }


    /**
     结题思想：采用双指针，分别指向开始节点，然后一个走一步，另一个走两步，由于走两步的走的步长是第一个一被，所以当两步步长走到头时，一步的指针刚好走到链表的中间，此时返回一步指针即可

     注意判定的条件：
        一步指针的下一步不能为空，如果为空，就不应该再走
        二步指针的下一步也不能为空，如果为空，说明已经走到链表尾部。
     */
    public ListNode middleNode(ListNode head) {
        if(head == null ||head.next == null) return head;
        ListNode oneStep = head,twoStep = head;
        while (twoStep != null && oneStep != null) {
            if(oneStep.next == null || twoStep.next == null) {
                break;
            }
            oneStep = oneStep.next;
            twoStep = twoStep.next.next;
        }
        return oneStep;
    }
}
