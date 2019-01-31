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

    private List<Integer> list;

    public List<Integer> preorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        traversal(root);
        return list;
    }

    private TreeNode traversal(TreeNode node) {
        if (node == null) return null;

        list.add(node.val);
        traversal(node.left);
        traversal(node.right);
        return node;
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