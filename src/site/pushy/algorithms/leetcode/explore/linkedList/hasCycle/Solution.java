package site.pushy.algorithms.leetcode.explore.linkedList.hasCycle;

import site.pushy.algorithms.leetcode.explore.linkedList.ListNode;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/1/4 17:07
 */
public class Solution {

    /**
     * 通过一个集合来保存访问过的节点，如果再次访问到之前访问到的节点，说明是环形的链表
     * @param head
     * @return
     */
//    public boolean hasCycle(ListNode head) {
//        Set<ListNode> nodes = new HashSet<>();
//
//        while (head != null) {
//            if (nodes.contains(head)) {
//                return true;
//            } else {
//                nodes.add(head);
//            }
//            head = head.next;
//        }
//        return false;
//    }

    /**
     * 通过双指针来实现
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            if (fast.next == null) {
                /* 如果不存在环，那么最终快指针将会最先到达尾部，此时我们可以返回false */
                return false;
            }
            /* 慢指针slow每次移动一步，而快指针fast每次移动两步 */
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {  // 即慢指针和快指针刚好相遇，说明是个环形链表
                return true;
            }
        }
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