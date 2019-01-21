package site.pushy.algorithms.leetcode.explore.hashTable.findDuplicateSubtrees;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 * @author Pushy
 * @since 2019/1/17 17:11
 */
public class Solution {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
//        https://segmentfault.com/a/1190000017891789
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        Solution solution = new Solution();
        List<TreeNode> res = solution.findDuplicateSubtrees(root);
        System.out.println("res：" + res);
    }

}