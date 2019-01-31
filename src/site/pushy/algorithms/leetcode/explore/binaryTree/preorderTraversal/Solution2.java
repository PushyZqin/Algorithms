package site.pushy.algorithms.leetcode.explore.binaryTree.preorderTraversal;

import site.pushy.algorithms.leetcode.explore.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 利用迭代的方式先序遍历
 *
 * @author Pushy
 * @since 2019/1/26 12:19
 */
public class Solution2 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) return res;
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null)
                continue;

            res.add(node.val);
            stack.push(node.left);
            stack.push(node.right);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        Solution2 solution = new Solution2();
        List<Integer> res = solution.preorderTraversal(root);
        System.out.println("res：" + res);
    }

}
