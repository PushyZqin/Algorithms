package site.pushy.algorithms.leetcode.explore.linkedList.getIntersectionNode;

import site.pushy.algorithms.leetcode.explore.linkedList.ListNode;

/**
 * @author Pushy
 * @since 2019/1/4 19:58
 */
public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        // pA == pB
        return pA;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode last = headB;
        while (last.next != null) {
            last = last.next;
        }
        last.next = headB;

        ListNode slow = headA, fast = headA;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = headA;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                last.next = null;
                return fast;
            }
        }
        last.next = null;
        return null;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);

        ListNode c = new ListNode(8);
        c.next = new ListNode(4);
        c.next.next = new ListNode(5);

        headA.next.next = c;
        headB.next.next.next = c;

        Solution solution = new Solution();
        ListNode res = solution.getIntersectionNode(headA, headB);
        System.out.println("res：" + res);
    }

}