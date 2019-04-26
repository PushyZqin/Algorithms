package site.pushy.algorithms.leetcode.explore.linkedList.addTwoNumbers;

import site.pushy.algorithms.leetcode.explore.linkedList.ListNode;
import site.pushy.algorithms.leetcode.explore.linkedList.ListUtil;

/**
 * @author Pushy
 * @since 2019/1/9 18:52
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = l1, q = l2, cur = dummy;
        int carry = 0;

        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) cur.next = new ListNode(carry);
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = ListUtil.getListByArray(new int[]{1, 3, 3});
        ListNode head2 = ListUtil.getListByArray(new int[]{2, 4, 7});

        Solution solution = new Solution();
        ListNode res = solution.addTwoNumbers(head1, head2);
        System.out.println("res：" + ListUtil.toString(res));
    }

}