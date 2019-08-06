package simple.tree;

import leetcode.explore.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 求二叉树中的节点个数
 * 1. 如果二叉树为空，节点个数为0
 * 2. 如果二叉树不为空，二叉树节点个数 = 左子树节点个数 + 右子树节点个数 + 1
 *
 * @author Pushy
 * @since 2019/1/27 16:17
 */
public class NodeCount {

    /**
     * 递归实现
     */
    public static int solution(TreeNode root) {
        if (root == null) return 0;

        return solution(root.left) + solution(root.right) + 1;
    }

    /**
     * 通过迭代来实现，基于层次遍历通过Queue解决，
     */
    public static int solution2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int res = 0;

        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null)
                continue;
            res+=1;
            queue.offer(node.left);
            queue.offer(node.right);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);
        root.right = right;

        int res = NodeCount.solution2(root);
        System.out.println("res: " + res);
    }

}
