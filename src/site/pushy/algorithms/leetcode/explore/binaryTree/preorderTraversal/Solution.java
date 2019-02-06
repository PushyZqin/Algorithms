package site.pushy.algorithms.leetcode.explore.binaryTree.preorderTraversal;

import site.pushy.algorithms.leetcode.explore.binaryTree.TreeNode;

import java.util.*;

/**
 * 利用递归的方式先序遍历
 *
 * @author Pushy
 * @since 2019/1/26 12:12
 */
public class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        return traversal(root, res);
    }

    public List<Integer> traversal(TreeNode node, List<Integer> res) {
        if (node == null) return res;
        res.add(node.val);
        traversal(node.left, res);
        traversal(node.right, res);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        Solution solution = new Solution();
        List<Integer> res = solution.preorderTraversal(root);
        System.out.println("res：" + res);
    }

}