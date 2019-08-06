package leetcode.problemset._104_Maximum_Depth_of_Binary_Tree;

import leetcode.explore.binaryTree.TreeNode;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/4/29 11:49
 */
public class Solution {

    /**
     * 递归实现
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int hl = maxDepth(root.left);
        int hr = maxDepth(root.right);

        return Math.max(hl, hr) + 1;
    }

    /**
     * 层序遍历迭代实现
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- != 0) {  // 把当前层所有结点的子结点都放入队列中
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);
        root.right = right;

        Solution solution = new Solution();
        int res = solution.maxDepth(root);
        System.out.println("res：" + res);
    }

}