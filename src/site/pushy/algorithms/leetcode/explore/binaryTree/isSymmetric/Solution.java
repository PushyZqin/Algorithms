package site.pushy.algorithms.leetcode.explore.binaryTree.isSymmetric;

import site.pushy.algorithms.leetcode.explore.binaryTree.TreeNode;

/**
 * 使用迭代解决
 * @author Pushy
 * @since 2019/1/26 23:14
 */
public class Solution {

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    /**
     * 递归调用判断是否为镜像二叉树
     * @param t1 结点的子树
     * @param t2 结点的子树
     */
    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return false;
        if (t1 == null || t2 == null) return false;

        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(2);

        left.left = new TreeNode(3);
        left.right = new TreeNode(4);
        right.left = new TreeNode(4);
        right.right = new TreeNode(3);

        root.left = left;
        root.right = right;

        Solution solution = new Solution();
//        Solution2 solution = new Solution2();
        boolean res = solution.isSymmetric(root);
        System.out.println("res：" + res);
    }

}