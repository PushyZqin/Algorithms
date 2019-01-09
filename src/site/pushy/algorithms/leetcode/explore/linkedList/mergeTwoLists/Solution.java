package site.pushy.algorithms.leetcode.explore.linkedList.mergeTwoLists;

import site.pushy.algorithms.leetcode.explore.linkedList.ListNode;
import site.pushy.algorithms.leetcode.explore.linkedList.ListUtil;

/**
 * @author Pushy
 * @since 2019/1/8 16:49
 */
public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }

            cur = cur.next;
        }

        cur.next = l1 != null ? l1 : l2;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        head1.next = node1;
        node1.next = node2;

        ListNode head2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head2.next = node3;
        node3.next = node4;

        Solution solution = new Solution();
        ListNode res = solution.mergeTwoLists(head1, head2);
        System.out.println("res：" + ListUtil.toString(res));
    }

}