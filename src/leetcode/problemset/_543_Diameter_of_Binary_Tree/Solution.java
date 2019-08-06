package leetcode.problemset._543_Diameter_of_Binary_Tree;

import leetcode.explore.binaryTree.TreeNode;
import leetcode.explore.binaryTree.TreeUtil;

/**
 * @author Pushy
 * @since 2019/5/5 17:13
 */
public class Solution {

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.deserialize("4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2");

        Solution solution = new Solution();
        int res = solution.diameterOfBinaryTree(root);
        System.out.println("res：" + res);
    }

}