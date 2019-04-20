package site.pushy.algorithms.leetcode.problemset._234_Palindrome_Linked_List;

import site.pushy.algorithms.leetcode.explore.linkedList.ListNode;
import site.pushy.algorithms.leetcode.explore.linkedList.ListUtil;

import java.util.Stack;

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

    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) return true;
        if (head.next.next == null) return head.val == head.next.val;

        ListNode slow = head, fast = head.next;

        while (fast.next != null) {
            if (slow.val == fast.next.val) {
                if (fast.next.next == null) return false;

                fast.next = null;
                slow = slow.next;
                fast = slow.next;
                if (fast == null || slow.val == fast.val) {
                    return true;
                }
            } else {
                fast = fast.next;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = ListUtil.getListByArray(new int[]{1, 2, 2, 1});

        Solution solution = new Solution();
        boolean res = solution.isPalindrome(head);
        System.out.println("res：" + res);
    }

}