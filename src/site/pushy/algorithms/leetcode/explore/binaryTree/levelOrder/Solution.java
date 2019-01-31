package site.pushy.algorithms.leetcode.explore.binaryTree.levelOrder;

import site.pushy.algorithms.leetcode.explore.binaryTree.TreeNode;

import java.util.*;

/**
 * 用广度优先搜索来实现层次遍历，并通过队列结构来实现
 *
 * @author Pushy
 * @since 2019/1/26 15:22
 */
public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        if (root == null) return res;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            while (size > 0) {  // 遍历每层的结点
                TreeNode node = queue.remove();
                list.add(node.val);

                if (node.left != null)
                    queue.offer(node.left);  // 将左子节点放入队列中
                if (node.right != null)
                    queue.offer(node.right); // 将右子节点放入队列中
                size--;
            }
            res.add(list);
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

        Solution solution = new Solution();
        List<List<Integer>> res = solution.levelOrder(root);
        System.out.println("res：" + res);
    }

}