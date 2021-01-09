package com.vincent.algorithm.basic.linkedlist;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 
 *
 * 示例 1：
 *
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 *
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * 
 *
 * 提示：
 *
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {

    }

    /**

     解题思路：
     1.创建一个新链表，来存放新的结果集
     2.使用三个指针分别指向结果集链表和两个入参链表
     3.通过比较大小，来实现将最小的链表节点，挂载到结果集链表中，并完成该链表的指针移动和结果集链表的指针移动
     4.容易出错的地方，结果集链表的指针移动到了最后，直接返回是错误的，需要在最开始多加一个指针保留结果集链表的头部。
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head = new ListNode(-1);
        ListNode result = head;
        while (l1!=null && l2!= null) {
            if(l1.val >=l2.val) {
                head.next = l2;
                l2 = l2.next;
            } else {
                head.next = l1;
                l1 = l1.next;
            }
            head = head.next;
        }
        head.next = l1 == null?l2:l1;
        return result.next;
    }
}
