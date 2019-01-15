package site.pushy.algorithms.leetcode.explore.linkedList.mergeTwoLists;

import site.pushy.algorithms.leetcode.explore.linkedList.ListNode;
import site.pushy.algorithms.leetcode.explore.linkedList.ListUtil;

/**
 * @author Pushy
 * @since 2019/1/8 16:49
 */
public class Solution {

    /**
     * 同时不断遍历两个链表，取出小的追加到新的头结点，直至两者其中一个为空
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /* 创建哑结点，这样就不用判断新链表的头结点是l1的头结点还是l2的头结点了 */
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

        /* 判断哪个链表先遍历完毕，就将另外一个链表拼接起来就行 */
        if (l1 == null) cur.next = l2;   // 代表l1先遍历完毕了
        if (l2 == null) cur.next = l1;   // 代表l2先遍历完毕了

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