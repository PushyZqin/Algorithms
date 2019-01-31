package site.pushy.algorithms.leetcode.explore.bst.searchBST;

import site.pushy.algorithms.leetcode.explore.binaryTree.TreeNode;

/**
 * @author Pushy
 * @since 2019/1/30 18:00
 */
public class Solution {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        else if (root.val < val)
            return searchBST(root.right, val);
        else
            return searchBST(root.left, val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        int val = 2;

        Solution solution = new Solution();
        TreeNode res = solution.searchBST(root, val);
        System.out.println("res：" + res);
    }

}