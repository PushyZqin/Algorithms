package leetcode.problemset._106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal;

import leetcode.explore.binaryTree.TreeNode;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/4/30 10:15
 */
public class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Todo buildTree

        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode res = solution.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        System.out.println("res：" + res);
    }

}