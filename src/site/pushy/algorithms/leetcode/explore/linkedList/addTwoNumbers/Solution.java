package site.pushy.algorithms.leetcode.explore.linkedList.addTwoNumbers;

import site.pushy.algorithms.leetcode.explore.linkedList.ListNode;

/**
 * @author Pushy
 * @since 2019/1/9 18:52
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        return null;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(2);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);
        head1.next = node1;
        node1.next = node2;

        ListNode head2 = new ListNode(5);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(4);
        head2.next = node3;
        node3.next = node4;

        Solution solution = new Solution();
        ListNode res = solution.addTwoNumbers(head1, head2);
        System.out.println("res：" + res);
    }

}