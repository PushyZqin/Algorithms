package leetcode.explore.binaryTree.hasPathSum;

import leetcode.explore.binaryTree.TreeNode;

/**
 * @author Pushy
 * @since 2019/4/30 9:55
 */
public class Solution {

    /**
     * 通过递归调用减去sum的值，那么到叶结点时，如果该结点的值和sum值相同，则说明路径上的和与目标和相等
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;

        if (root.left == null && root.right == null && root.val == sum)
            return true;

        boolean hasLeft = hasPathSum(root.left, sum - root.val);
        boolean hasRight = hasPathSum(root.right, sum - root.val);

        return hasLeft || hasRight;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(4);
        TreeNode right = new TreeNode(8);

        left.left = new TreeNode(11);
        left.left.left = new TreeNode(7);
        left.left.right = new TreeNode(2);

        right.left = new TreeNode(13);
        right.right = new TreeNode(4);
        right.right.right = new TreeNode(1);

        root.left = left;
        root.right = right;

        Solution solution = new Solution();
        boolean res = solution.hasPathSum(root, 22);
        System.out.println("res：" + res);
    }

}