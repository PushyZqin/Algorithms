package leetcode.explore.bst.isBalanced;

import leetcode.explore.binaryTree.TreeNode;

/**
 * @author Pushy
 * @since 2019/1/31 11:24
 */
public class Solution {

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(level(root.left) - level(root.right)) > 1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int level(TreeNode root) {
        if (root == null) return 0;
        return Math.max(level(root.left), level(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution solution = new Solution();
        boolean res = solution.isBalanced(root);
        System.out.println("res：" + res);
    }

}