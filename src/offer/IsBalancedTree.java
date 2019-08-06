package offer;

import leetcode.explore.binaryTree.TreeNode;
import leetcode.explore.binaryTree.TreeUtil;

public class IsBalancedTree {

//    public boolean IsBalanced_Solution(TreeNode root) {
//        if (root == null) return true;
//
//        int left = getDepth(root.left);
//        int right = getDepth(root.right);
//
//        int abs = Math.abs(left - right);
//        if (abs > 1) return false;
//
//        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
//    }
//
//    private int getDepth(TreeNode root) {
//        if (root == null) return 0;
//
//        int left = getDepth(root.left);
//        int right = getDepth(root.right);
//
//        return left > right ? left + 1 : right + 1;
//    }

    public boolean IsBalanced_Solution(TreeNode root) {
        return getDepth(root) != -1;
    }

    /**
     * 后序遍历自底向上判断左右子树是否平衡
     */
    private int getDepth(TreeNode root) {
        if (root == null) return 0;

        int left = getDepth(root.left);
        if (left == -1) return -1;

        int right = getDepth(root.right);
        if (right == -1) return -1;

        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.deserialize("1,2,3,4,5,6,null,7,8,null,null,null,null,null,null,9,10");
        IsBalancedTree balancedTree = new IsBalancedTree();
        System.out.println(balancedTree.IsBalanced_Solution(root));
    }

}
