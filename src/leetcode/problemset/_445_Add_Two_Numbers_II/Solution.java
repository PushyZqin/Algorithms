package leetcode.problemset._445_Add_Two_Numbers_II;

import leetcode.explore.linkedList.ListNode;
import leetcode.explore.linkedList.ListUtil;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/4/20 11:38
 */
public class Solution {

    /**
     * 使用三个栈来实现
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<>(), s2 = new Stack<>();
        Stack<ListNode> stack = new Stack<>();

        for (ListNode cur = l1; cur != null; cur = cur.next) s1.push(cur);
        for (ListNode cur = l2; cur != null; cur = cur.next) s2.push(cur);

        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int a = s1.isEmpty() ? 0 : s1.pop().val;
            int b = s2.isEmpty() ? 0 : s2.pop().val;
            int sum = a + b + carry;
            carry = sum / 10;
            stack.push(new ListNode(sum % 10));
        }
        if (carry != 0) stack.push(new ListNode(1));

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!stack.isEmpty()) {
            cur.next = stack.pop();
            cur = cur.next;
        }
        return dummy.next;
    }

    /**
     * 去除一个栈，将结果追加到dummy链表后，最后再反转链表
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<>(), s2 = new Stack<>();
        ListNode dummy = new ListNode(0);

        for (ListNode cur = l1; cur != null; cur = cur.next) s1.push(cur);
        for (ListNode cur = l2; cur != null; cur = cur.next) s2.push(cur);

        int carry = 0;
        ListNode cur = dummy;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int a = s1.isEmpty() ? 0 : s1.pop().val;
            int b = s2.isEmpty() ? 0 : s2.pop().val;
            int sum = a + b + carry;
            carry = sum / 10;

            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }
        if (carry != 0) cur.next = new ListNode(1);

        return reverseList(dummy.next);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode reHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return reHead;
    }

    public static void main(String[] args) {
        ListNode l1 = ListUtil.getListByArray(new int[]{5});
        ListNode l2 = ListUtil.getListByArray(new int[]{5});

        Solution solution = new Solution();
        ListNode res = solution.addTwoNumbers2(l1, l2);
        System.out.println("res：" + ListUtil.toString(res));
    }

}