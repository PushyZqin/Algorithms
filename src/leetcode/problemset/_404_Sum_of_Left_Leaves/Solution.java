package leetcode.problemset._404_Sum_of_Left_Leaves;

import leetcode.explore.binaryTree.TreeNode;
import leetcode.explore.binaryTree.TreeUtil;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/5/4 20:43
 */
public class Solution {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            return root.left.val + sumOfLeftLeaves(root.right);
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.deserialize("3,9,20,null,null,15,7");

        Solution solution = new Solution();
        int res = solution.sumOfLeftLeaves(root);
        System.out.println("res：" + res);
    }

}