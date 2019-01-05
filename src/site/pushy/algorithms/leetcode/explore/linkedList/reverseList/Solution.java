package site.pushy.algorithms.leetcode.explore.linkedList.reverseList;

import site.pushy.algorithms.leetcode.explore.linkedList.ListNode;
import site.pushy.algorithms.leetcode.explore.linkedList.ListUtil;

/**
 * @author Pushy
 * @since 2019/1/4 21:18
 */
public class Solution {

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode next = null;
        ListNode pre = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        System.out.println(ListUtil.toString(head));

        Solution solution = new Solution();
        ListNode res = solution.reverseList(head);

        System.out.println("res：" + ListUtil.toString(res));
    }

}