package site.pushy.algorithms.leetcode.explore.linkedList.removeNthFromEnd;

import site.pushy.algorithms.leetcode.explore.linkedList.ListNode;

/**
 * @author Pushy
 * @since 2019/1/4 20:56
 */
public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        ListNode fast = head;  // 快指针
        ListNode slow = head;  // 慢指针

        /* 先让快指针先移动n个单位 */
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        if (fast == null) return head.next; // 如果删除的是头结点

        /* 让快指针和慢指针以相同的单位移动，当快指针指向链表末尾时，慢指针指向的即待删除的节点 */
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        Solution solution = new Solution();
        ListNode res = solution.removeNthFromEnd(head, 2);
        System.out.println("res：" + res);
    }

}