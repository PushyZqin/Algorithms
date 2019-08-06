package simple.tree;

import leetcode.explore.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 求二叉树第k层的节点个数
 *
 * @author Pushy
 * @since 2019/1/27 16:42
 */
public class TreeKthLevelNodeNum {

    /**
     * 递归解法
     */
    public static int solution(TreeNode root, int k) {
        if (root == null || k < 1) return 0;
        if (k == 1) return 1;  // 到达叶子的层数，返回1

        /* 返回root左子树中k-1层的节点个数与root右子树k-1层节点个数之和 */
       return solution(root.left, k - 1) + solution(root.right, k - 1);
    }

    /**
     * 迭代解法，基于层次遍历实现，当遍历的深度等于k时，队列中的数量即该层的结点数量
     */
    public static int solution2(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 1;

        queue.offer(root);
        while (!queue.isEmpty()) {
            if (depth == k) return queue.size();

            int size = queue.size();
            while (size-- != 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            depth++;
        }
        return -1;
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

        int k = 3;
        int result = TreeKthLevelNodeNum.solution(root, k);
        System.out.println(result);
    }

}