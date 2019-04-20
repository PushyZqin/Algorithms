package site.pushy.algorithms.leetcode.explore.linkedList.rotateRight;

import site.pushy.algorithms.leetcode.explore.linkedList.ListNode;
import site.pushy.algorithms.leetcode.explore.linkedList.ListUtil;

/**
 * @author Pushy
 * @since 2019/1/9 19:00
 */
public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        /* 首先找到尾节点，并统计链表的长度 */
        int count = 1;
        ListNode tail = head;
        while (tail.next != null) {
            count++;
            tail = tail.next;
        }

        k = k % count;
        if (k == 0) return head;

        ListNode prev = head;
        /* 通过迭代找着新的节点的前驱结点 */
        for (int i = 0; i < count - k - 1; i++) {
            prev = prev.next;
        }

        ListNode newHead = prev.next;  // 保存新的头结点
        prev.next = null;              // 从新的头结点处断开
        tail.next = head;

        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = ListUtil.getListByArray(new int[]{1, 2, 3, 4, 5});

        Solution solution = new Solution();
        ListNode res = solution.rotateRight(head, 2);
        System.out.println("res：" + ListUtil.toString(res));
    }

}