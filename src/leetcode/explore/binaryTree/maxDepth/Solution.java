package site.pushy.algorithms.leetcode.explore.binaryTree.maxDepth;

import site.pushy.algorithms.leetcode.explore.binaryTree.TreeNode;

/**
 * @author Pushy
 * @since 2019/1/26 23:07
 */
public class Solution {

    private int res = 0;

    public int maxDepth(TreeNode root) {
        maximumDepth(root, 1);
        return res;
    }

    public void maximumDepth(TreeNode node, int depth) {
        if (node == null)
            return;

        if (node.left == null && node.right == null) { // 叶结点
            res = Math.max(res, depth);
        }
        maximumDepth(node.left, depth + 1);
        maximumDepth(node.right, depth + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);
        root.right = right;

        Solution solution = new Solution();
//        Main solution = new Main();

        int res = solution.maxDepth(root);
        System.out.println("res：" + res);
    }

}