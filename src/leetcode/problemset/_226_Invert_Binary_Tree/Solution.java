package leetcode.problemset._226_Invert_Binary_Tree;

import leetcode.explore.binaryTree.TreeNode;
import leetcode.explore.binaryTree.TreeUtil;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/5/5 14:48
 */
public class Solution {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    /**
     * 先序遍历交换
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;

        TreeNode left = root.left;
        root.left = invertTree2(root.right);
        root.right = invertTree2(left);

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.deserialize("4,2,7,1,3,6,9");

        Solution solution = new Solution();
        TreeNode res = solution.invertTree(root);
        System.out.println("res：" + res.left.left);
    }

}