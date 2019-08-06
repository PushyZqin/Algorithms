package leetcode.explore.bst.isValidBST;

import leetcode.explore.binaryTree.TreeNode;

import java.util.Stack;

/**
 * @author Pushy
 * @since 2019/1/30 17:11
 */
public class Solution2 {

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode pre = null;

        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                if (pre != null && node.val <= pre.val) return false;
                pre = node;
                node = node.right;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        Solution2 solution = new Solution2();
        boolean res = solution.isValidBST(root);
        System.out.println("res：" + res);
    }

}
