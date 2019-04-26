package site.pushy.algorithms.leetcode.problemset;

import site.pushy.algorithms.leetcode.explore.linkedList.ListNode;
import site.pushy.algorithms.leetcode.explore.linkedList.ListUtil;

/**
 * @author Pushy
 * @since 2019/1/8 15:50
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.next.val == cur.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.next = node1;
        node1.next = node2;

        RemoveDuplicatesFromSortedList solution = new RemoveDuplicatesFromSortedList();
        ListNode res = solution.deleteDuplicates(head);

        System.out.println("res：" + ListUtil.toString(res));
    }

}
