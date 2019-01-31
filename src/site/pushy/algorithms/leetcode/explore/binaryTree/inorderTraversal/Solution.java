package site.pushy.algorithms.leetcode.explore.binaryTree.inorderTraversal;

import site.pushy.algorithms.leetcode.explore.binaryTree.TreeNode;

import java.util.*;

/**
 * 用递归实现中序遍历
 *
 * @author Pushy
 * @since 2019/1/26 12:29
 */
public class Solution {

    private List<Integer> res;

    public List<Integer> inorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        traversal(root);
        return res;
    }

    public TreeNode traversal(TreeNode root) {
        if (root == null) return null;

        traversal(root.left);
        res.add(root.val);
        traversal(root.right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        Solution solution = new Solution();
        List<Integer> res = solution.inorderTraversal(root);
        System.out.println("res：" + res);
    }

}