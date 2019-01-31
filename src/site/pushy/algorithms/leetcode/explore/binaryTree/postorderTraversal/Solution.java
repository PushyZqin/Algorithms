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

    private List<Integer> list;

    public List<Integer> postorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        traversal(root);
        return list;
    }

    private TreeNode traversal(TreeNode node) {
        if (node == null) return null;

        traversal(node.left);
        traversal(node.right);
        list.add(node.val);
        return node;
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