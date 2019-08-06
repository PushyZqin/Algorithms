package leetcode.explore.linkedList.isPalindrome;

import leetcode.explore.linkedList.ListNode;

/**
 * @author Pushy
 * @since 2019/1/5 19:54
 */
public class Solution1 {

    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow = reverse(slow.next);  // 将中间结点到链表末尾的所有结点翻转

        /* 让头结点和中间结点开始向后移动，对比它们的结点值是否相等 */
        while (head != null && slow != null && head.val == slow.val) {
            head = head.next;
            slow = slow.next;
        }
        return slow == null;
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
