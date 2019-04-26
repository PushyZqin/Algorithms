package site.pushy.algorithms.leetcode.explore.linkedList.removeNthFromEnd;

import site.pushy.algorithms.leetcode.explore.linkedList.ListNode;
import site.pushy.algorithms.leetcode.explore.linkedList.ListUtil;

/**
 * @author Pushy
 * @since 2019/4/15 11:25
 */
public class Solution2 {

    /**
     * 两趟遍历，一趟计算链表的长度，一趟删除 l - n + 1 的结点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) return head;

        ListNode cur = head;
        int l = 0; // 链表的长度
        while (cur != null) { // 计算链表的长度
            cur = cur.next;
            l++;
        }

        if (n > l) return head;        // 不合理的删除位置
        if (n == l) return head.next;  // 头结点

        int i = 0;
        cur = head;
        while (i < l - n - 1) {
            cur = cur.next;
            i++;
        }
        cur.next = cur.next.next;  // 删除结点
        return head;
    }

    /**
     * 使用哑结点技巧的操作
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int l = 0;
        ListNode cur = head;
        while (cur != null) {
            l++;
            cur = cur.next;
        }

        l -= n;
        cur = dummy;
        while (l > 0) {
            l--;
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        ListNode head = ListUtil.getListByArray(new int[]{1, 2, 3, 4, 5});
        System.out.println(ListUtil.toString(solution.removeNthFromEnd(head, 2)));
        System.out.println(ListUtil.toString(solution.removeNthFromEnd2(head, 2)));
    }

}
