package site.pushy.algorithms.leetcode.explore.binaryTree.postorderTraversal;

import site.pushy.algorithms.leetcode.explore.binaryTree.TreeNode;

import java.util.*;

/**
 * 用递归实现二叉树的后续遍历
 *
 * @author Pushy
 * @since 2019/1/26 15:00
 */
public class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        return traversal(root, res);
    }

    private List<Integer> traversal(TreeNode root, List<Integer> res) {
        if (root == null) return res;

        traversal(root.left, res);
        traversal(root.right, res);
        res.add(root.val);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        Solution solution = new Solution();
        List<Integer> res = solution.postorderTraversal(root);
        System.out.println("res：" + res);
    }

}