package leetcode.problemset._24_Swap_Nodes_in_Pairs;

import leetcode.explore.linkedList.ListNode;
import leetcode.explore.linkedList.ListUtil;

/**
 * @author Pushy
 * @since 2019/4/17 10:34
 */
public class Solution {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode cur = head;
        ListNode next = head.next;

        head = next;
        while (cur != null) {
            ListNode temp = next.next;
            next.next = cur;
            cur.next = temp == null ? null : temp.next;

            if (temp == null) break;
            cur = temp;
            next = temp.next;
        }
        return head;
    }

    public ListNode swapPairs2(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode temp = cur.next.next;
            cur.next.next = temp.next;

            temp.next = cur.next;
            cur.next = temp;
            cur = temp.next;
        }
        return dummy.next;
    }

    public ListNode swapPairs3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs3(next.next);

        next.next = head;
        return next;
    }

    public static void main(String[] args) {
        ListNode head = ListUtil.getListByArray(new int[]{1, 2, 3, 4});

        Solution solution = new Solution();
        ListNode res = solution.swapPairs2(head);
        System.out.println("res：" + ListUtil.toString(res));
    }

}