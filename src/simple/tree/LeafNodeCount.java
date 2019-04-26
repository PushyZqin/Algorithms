package site.pushy.algorithms.simple.tree;

import site.pushy.algorithms.leetcode.explore.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 求二叉树中叶子节点的个数
 *
 * @author Pushy
 * @since 2019/1/28 10:40
 */
public class LeafNodeCount {

    /**
     * 递归解决
     */
    public static int solution(TreeNode root) {
        if (root == null) return 0;  // 树为空，返回0
        /* 如果是叶结点，则返回1 */
        if (root.left == null && root.right == null) return 1;

        /* 如果二叉树不是叶节点，递归调用计算叶子总数 = 左子树叶子结点数 + 右子树叶子结点数 */
        return solution(root.left) + solution(root.right);
    }

    /**
     * 迭代解决，基于层次遍历进行求解，通过Queue来实现
     */
    public static int solution2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int res = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null)
                continue;
            if (node.left == null && node.right == null) // 叶节点
                res++;
            else {
                /* 如果不是叶节点，将该结点的左子树和右子树放入队列，等待下次遍历 */
                queue.offer(node.right);
                queue.offer(node.left);
            }
        }
        return res;
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

        int result = LeafNodeCount.solution2(root);
        System.out.println(result);
    }

}