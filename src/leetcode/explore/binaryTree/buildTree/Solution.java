package site.pushy.algorithms.leetcode.explore.binaryTree.buildTree;

import site.pushy.algorithms.leetcode.explore.binaryTree.TreeNode;

/**
 * @author Pushy
 * @since 2019/1/27 16:13
 */
public class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(postorder, inorder, postorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode build(int[] postorder, int[] inorder, int postEnd, int inStart, int inEnd) {
        if (inStart > inEnd) return null;  // 递归的终止条件

        TreeNode root = new TreeNode(postorder[postEnd]);
        int index = 0;
        /* 寻找root.val在前序遍历数组中的索引值 */
        for (int i = inEnd; i >= inStart; i--) {
            if (root.val == inorder[i]) {
                index = i;
                break;
            }
        }
        root.right = build(postorder, inorder, postEnd - 1, index + 1, inEnd);
        root.left = build(postorder, inorder, postEnd - 1 + index - inEnd, inStart, index - 1);
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        Solution solution = new Solution();
        TreeNode res = solution.buildTree(inorder, postorder);
        System.out.println("res：" + res);
    }

}