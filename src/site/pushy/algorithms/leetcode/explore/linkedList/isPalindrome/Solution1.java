package site.pushy.algorithms.leetcode.explore.linkedList.isPalindrome;

import site.pushy.algorithms.leetcode.explore.linkedList.ListNode;

/**
 * @author Pushy
 * @since 2019/1/5 19:54
 */
public class Solution1 {

    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;

        ListNode middle = findMiddle(head);  // 找到链表的中间结点
        middle.next = reverse(middle.next);  // 将中间结点到链表末尾的所有结点翻转

        ListNode p1 = head;
        ListNode p2 = middle.next;

        /* 让头结点和中间结点开始向后移动，对比它们的结点值是否相等 */
        while (p1 != null && p2 != null && p1.val == p2.val) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2 == null;
    }

    /**
     * 通过双指针找到中间的结点
     */
    private ListNode findMiddle(ListNode head) {
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    /**
     * 翻转链表
     */
    private ListNode reverse(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        Solution1 solution = new Solution1();
        boolean res = solution.isPalindrome(head);
        System.out.println("res：" + res);
    }

}
