package site.pushy.algorithms.leetcode.explore.linkedList.oddEvenList;

import site.pushy.algorithms.leetcode.explore.linkedList.ListNode;
import site.pushy.algorithms.leetcode.explore.linkedList.ListUtil;

/**
 * @author Pushy
 * @since 2019/1/5 19:05
 */
public class Solution {

    /**
     * 隔一个取一个元素，新建一个链表，把取出来的索引为偶数的元素放进去，原链表剩下的都是索引为奇数的元素
     * 再把两个链表拼接起来，就可以得到结果
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;  // 拼接

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Solution solution = new Solution();
        ListNode res = solution.oddEvenList(head);
        System.out.println("res：" + ListUtil.toString(res));
    }

}