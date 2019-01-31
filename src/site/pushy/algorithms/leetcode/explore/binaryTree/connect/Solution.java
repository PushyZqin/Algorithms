package site.pushy.algorithms.leetcode.explore.binaryTree.connect;

import site.pushy.algorithms.leetcode.explore.binaryTree.TreeLinkNode;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/1/30 10:33
 */
public class Solution {

    /**
     * 通过递归实现
     * @param root
     */
    public void connect(TreeLinkNode root) {
        if (root == null || root.left == null) {
            return;
        }
        root.left.next = root.right;
        if (root.next != null) {
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
    }

    /**
     * 通过Queue实现层级遍历，然后将上一个结点的next指针指向当前遍历的结点
     */
    public void connect2(TreeLinkNode root) {
        if (root == null) return;

        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeLinkNode pre = null;
            while (size-- > 0) {
                TreeLinkNode cur = queue.poll();
                if (pre == null) {
                    pre = cur;
                } else {
                    pre.next = cur;
                    pre = cur;
                }
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        root.right.left = new TreeLinkNode(6);
        root.right.right = new TreeLinkNode(7);

        Solution solution = new Solution();
        solution.connect(root);

        System.out.println(root.left.right.next);
    }

}