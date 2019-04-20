package site.pushy.algorithms.leetcode.explore.linkedList.reverseList;

import site.pushy.algorithms.leetcode.explore.linkedList.ListNode;
import site.pushy.algorithms.leetcode.explore.linkedList.ListUtil;

import java.util.Stack;

/**
 * 通过递归来实现反转链表
 *
 * @author Pushy
 * @since 2019/1/8 14:33
 */
public class Solution2 {

    /**
     * 在反转当前节点之前先反转后续节点。
     * 这样从头结点开始，层层深入直到尾结点才开始反转指针域的指向。
     * 简单的说就是从尾结点开始，逆向反转各个结点的指针域指向
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode reHead = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return reHead;
    }

    /**
     * 用自己维护的栈结构来实现
     */
    public ListNode reverseListStack(ListNode head) {
        Stack<ListNode> stack = new Stack<>();

        while (head != null) {
            stack.add(head);
            head = head.next;
        }

        ListNode cur = stack.pop();
        head = cur;
        while (!stack.empty()) {
            ListNode next = stack.pop();
            next.next = null;
            cur.next = next;
            cur = next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        Solution2 solution = new Solution2();
        ListNode res = solution.reverseListStack(head);

        System.out.println("res：" + ListUtil.toString(res));
    }

}
