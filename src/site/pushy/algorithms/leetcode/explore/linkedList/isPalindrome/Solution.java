package site.pushy.algorithms.leetcode.explore.linkedList.isPalindrome;

import site.pushy.algorithms.leetcode.explore.linkedList.ListNode;

import java.util.*;

/**
 * 通过双指针配合栈来解决
 *
 * @author Pushy
 * @since 2019/1/5 19:26
 */
public class Solution {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        Stack<ListNode> stack = new Stack<>();
        ListNode fast = head;  // 快指针
        ListNode slow = head;  // 慢指针

        /* 当快指针到达链表的末尾，慢指针则该链表的中间 */
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        /* 将慢指针向后移动，并将每个结点都入栈 */
        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }
        /* 遍历栈中的元素，与头结点往后遍历对比，就可以判断出是否是回文结构的链表 */
        while (!stack.isEmpty()) {
            if (stack.pop().val != head.val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        Solution solution = new Solution();
        boolean res = solution.isPalindrome(head);
        System.out.println("res：" + res);
    }

}