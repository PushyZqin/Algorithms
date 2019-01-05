package site.pushy.algorithms.leetcode.explore.linkedList.removeElements;

import site.pushy.algorithms.leetcode.explore.linkedList.ListNode;

/**
 * @author Pushy
 * @since 2019/1/5 18:53
 */
public class Solution1 {

    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head == null) return null;

        ListNode pre = head;
        ListNode cur = head.next;

        while (cur != null) {
            while (cur != null && cur.val != val) {  // 寻找等于val的结点
                pre = cur;
                cur = cur.next;
            }

            if (cur == null) {
                break;
            }
            /* 删除该结点 */
            pre.next = cur.next;
            cur = cur.next;
        }

        return head;
    }

}
