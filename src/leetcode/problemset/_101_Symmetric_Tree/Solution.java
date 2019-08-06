package leetcode.problemset._101_Symmetric_Tree;

import leetcode.explore.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Pushy
 * @since 2019/4/29 16:23
 */
public class Solution {

    /**
     * 递归实现
     *
     * @param root
     */
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;   // 左右子树都为空，为镜像
        if (left == null || right == null) return false;  // 左右子树其中一个为空，不是镜像

        return left.val == right.val
                && isSymmetric(left.left, right.right)
                && isSymmetric(left.right, right.left);
    }

    /**
     * 迭代实现
     */
    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();

            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;

            // 将左子树的左结点与右子树的右结点比较
            queue.offer(t1.left);
            queue.offer(t2.right);

            // 将左子树的右结点与右子树的左结点比较
            queue.offer(t1.right);
            queue.offer(t2.left);
        }
        return true;
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
        boolean res = solution.isSymmetric2(root);
        System.out.println("res：" + res);
    }

}