package site.pushy.algorithms.leetcode.explore.bst.sortedArrayToBST;

import site.pushy.algorithms.leetcode.explore.binaryTree.TreeNode;

/**
 * @author Pushy
 * @since 2019/2/1 10:22
 */
public class Solution {

    /**
     * 选择中间元素作为根结点
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        return sortedArrayHelper(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayHelper(int[] nums, int start, int end) {
        if (start > end) return null;

        int mid = start + (end - start) / 2;  // 防止溢出
        TreeNode root = new TreeNode(nums[mid]);

        root.left = sortedArrayHelper(nums, start, mid - 1);  // 将右边数组用来构造右子树
        root.right = sortedArrayHelper(nums, mid + 1, end);   // 将左边数组用来构造左子树
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};

        Solution solution = new Solution();
        TreeNode res = solution.sortedArrayToBST(nums);
        System.out.println("res：" + res);
    }

}