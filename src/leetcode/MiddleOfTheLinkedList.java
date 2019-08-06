package leetcode;

import leetcode.explore.linkedList.ListNode;

/**
 * @author Pushy
 * @since 2019/1/8 16:31
 * @link https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */
public class MiddleOfTheLinkedList {

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (slow != null && fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        head.next = node1;
        node1.next = node2;

        MiddleOfTheLinkedList solution = new MiddleOfTheLinkedList();
        ListNode res = solution.middleNode(head);
        System.out.println("res：" + res);
    }

}
