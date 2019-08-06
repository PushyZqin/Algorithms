package leetcode.problemset._100_Same_Tree;

import leetcode.explore.binaryTree.TreeNode;
import leetcode.explore.binaryTree.TreeUtil;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/5/4 15:57
 */
public class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return equals(p, q);
    }

    private boolean equals(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;

        return t1.val == t2.val
                && equals(t1.left, t2.left) && equals(t1.right, t2.right);
    }

    public static void main(String[] args) {
        TreeNode p = TreeUtil.deserialize("1,2,1");
        TreeNode q = TreeUtil.deserialize("1,1,2");

        Solution solution = new Solution();
        boolean res = solution.isSameTree(p, q);
        System.out.println("res：" + res);
    }

}