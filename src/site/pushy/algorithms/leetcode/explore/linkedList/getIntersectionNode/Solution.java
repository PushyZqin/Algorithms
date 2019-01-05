package site.pushy.algorithms.leetcode.explore.linkedList.getIntersectionNode;

import site.pushy.algorithms.leetcode.explore.linkedList.ListNode;

import java.util.List;
import java.util.Stack;

/**
 * @author Pushy
 * @since 2019/1/4 19:58
 */
public class Solution {

    /**
     * 通过暴力求解
     */
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        if (headA == headB) return headA;
//
//        /* 遍历链表A */
//        while (headA != null) {
//            headA = headA.next;
//
//            ListNode node = headB;
//            while (node != null) {
//                if (headA == node) {
//                    return headA;
//                }
//                node = node.next;
//            }
//        }
//        return null;
//    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp = null;

        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        while (!stack1.empty() && stack2.empty()) {
            temp = stack1.pop();
            stack1.pop();
            stack2.pop();
            if (stack1.peek() != stack2.peek()) {
                break;
            }
        }

        return temp;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        ListNode nodeA2 = new ListNode(1);
        headA.next = nodeA2;

        ListNode headB = new ListNode(5);
        ListNode nodeB2 = new ListNode(0);
        ListNode nodeB3 = new ListNode(1);
        headB.next = nodeB2;
        nodeB2.next = nodeB3;

        ListNode node1 = new ListNode(8);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);

        nodeA2.next = node1;
        nodeB3.next = node1;

        node1.next = node2;
        node2.next = node3;

        Solution solution = new Solution();
        ListNode res = solution.getIntersectionNode(headA, headB);
        System.out.println("res：" + res);
    }

}