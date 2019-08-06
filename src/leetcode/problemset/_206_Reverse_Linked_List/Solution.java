package leetcode.problemset._206_Reverse_Linked_List;

import leetcode.explore.linkedList.ListNode;
import leetcode.explore.linkedList.ListUtil;

/**
 * @author Pushy
 * @since 2019/1/4 21:18
 */
public class Solution {

    public ListNode reverseList(ListNode head) {
        /* 如果该链表没有头结点或者只有一个头结点，则原样返回head  */
        if (head == null || head.next == null) return head;

        ListNode next;   // 临时结点，用力保存当前结点的下一结点
        ListNode pre = null;

        while (head != null) {
            next = head.next;  // 保存后继节点
            head.next = pre;   // 让当前的头结点上一个头结点
            pre = head;        // 当前头结点赋值给pre，将在下一个头结点的后继指向该节点
            head = next;
        }
        return pre;  // 返回pre，即反转链表的头结点
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        System.out.println(ListUtil.toString(head));

        Solution solution = new Solution();
        ListNode res = solution.reverseList(head);

        System.out.println("res：" + ListUtil.toString(res));
    }

}