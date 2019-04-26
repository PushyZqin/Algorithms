package site.pushy.algorithms.leetcode.explore.binaryTree.maxDepth;

import site.pushy.algorithms.leetcode.explore.binaryTree.TreeNode;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/1/27 16:32
 */
public class Solution2 {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len-- != 0) {  // 把当前层所有结点的子结点都放入队列中
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            depth++;
        }
        return depth;
    }

}
