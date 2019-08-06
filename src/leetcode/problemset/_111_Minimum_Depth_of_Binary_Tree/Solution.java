package leetcode.problemset._111_Minimum_Depth_of_Binary_Tree;

import leetcode.explore.binaryTree.TreeNode;
import leetcode.explore.binaryTree.TreeUtil;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/5/4 16:13
 */
public class Solution {

    public int minDepth(TreeNode root) {
        return min(root);
    }

    public int min(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        if (root.left == null)
            return min(root.right) + 1;
        if (root.right == null)
            return min(root.left) + 1;

        return Math.min(min(root.right), min(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.deserialize("1,2");

        Solution solution = new Solution();
        int res = solution.minDepth(root);
        System.out.println("res：" + res);
    }

}