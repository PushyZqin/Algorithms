package leetcode.explore.linkedList.hasCycle;

import leetcode.explore.linkedList.ListNode;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/1/4 17:07
 */
public class Solution {

    /**
     * 通过一个集合来保存访问过的节点，如果再次访问到之前访问到的节点，说明是环形的链表
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) { // 有环
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 通过双指针来实现
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {  // 如果存在环，慢指针和快指针刚好相遇，说明是个环形链表
                return true;
            }
        }
        // 如果不存在环，那么最终快指针将会最先到达尾部
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);

        head.next = node1;
        node1.next = node2;
        node3.next = node3;
        node3.next = node1;

        Solution solution = new Solution();
        boolean res = solution.hasCycle(head);
        System.out.println("res：" + res);
    }

}