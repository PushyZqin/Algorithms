package site.pushy.algorithms.leetcode.problemset._237_deleteNode;

import site.pushy.algorithms.leetcode.explore.linkedList.ListNode;
import site.pushy.algorithms.leetcode.explore.linkedList.ListUtil;

/**
 * @author Pushy
 * @since 2019-2-4 09:46:28
 * @see https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 */
public class Solution {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;      // 将该结点的值设置为后继的值
        node.next = node.next.next;    // 删除后继结点
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(4);
        root.next = new ListNode(5);
        root.next.next = new ListNode(1);
        root.next.next.next = new ListNode(9);

        Solution solution = new Solution();
        solution.deleteNode(root.next);

        System.out.println(ListUtil.toString(root));
    }

}