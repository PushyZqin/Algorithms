package site.pushy.algorithms.leetcode.explore.linkedList.removeNthFromEnd;

import site.pushy.algorithms.leetcode.explore.linkedList.ListNode;
import site.pushy.algorithms.leetcode.explore.linkedList.ListUtil;

/**
 * @author Pushy
 * @since 2019/1/4 20:56
 */
public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        ListNode slow = head, fast = head;
        for (int i = 0; i < n; i++) { // 先让快指针先移动n个单位
            fast = fast.next;
        }
        // 如果删除的是头结点，直接返回头结点的后继
        if (fast == null) return head.next;

        // 让快指针和慢指针以相同的单位移动
        // 当快指针指向链表末尾时，慢指针则为即待删除的结点的前驱
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;  // 删除结点
        return head;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy, fast = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = ListUtil.getListByArray(new int[]{1, 2, 3, 4, 5});

        Solution solution = new Solution();
        ListNode res = solution.removeNthFromEnd2(head, 2);
        System.out.println("res：" + ListUtil.toString(res));
    }

}