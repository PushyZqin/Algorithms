package leetcode.explore.bst.insertIntoBST;

import leetcode.explore.binaryTree.TreeNode;

/**
 * @author Pushy
 * @since 2019/1/30 18:31
 */
public class Solution {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        return insertHelper(root, val);
    }

    public TreeNode insertHelper(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        if (root.val > val) // 该节点值比插入结点值大时，应该插入到右结点
            root.left = insertHelper(root.left, val);
        else  // 该节点值比插入结点值小时，应该插入到左结点
            root.right = insertHelper(root.right, val);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        int val = 5;

        Solution solution = new Solution();
        TreeNode res = solution.insertIntoBST(root, val);
        System.out.println("res：" + res);
    }

}