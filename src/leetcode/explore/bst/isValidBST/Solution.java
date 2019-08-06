package leetcode.explore.bst.isValidBST;

import leetcode.explore.binaryTree.TreeNode;

/**
 * @author Pushy
 * @since 2019/1/30 16:39
 */
public class Solution {

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;

        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        Solution solution = new Solution();
        boolean res = solution.isValidBST(root);
        System.out.println("res：" + res);
    }

}