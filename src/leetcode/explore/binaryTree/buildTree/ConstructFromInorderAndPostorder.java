package leetcode.explore.binaryTree.buildTree;

import leetcode.explore.binaryTree.TreeNode;

/**
 * @author Pushy
 * @since 2019/1/27 16:13
 */
public class ConstructFromInorderAndPostorder {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(postorder, inorder, postorder.length - 1, 0, inorder.length - 1);
        // return bfs_buildTree(inorder, postorder, 0, postorder.length, postorder.length);
    }

    public TreeNode build(int[] postorder, int[] inorder, int postRight, int inLeft, int inRight) {
        if (inLeft > inRight) return null;  // 递归的终止条件

        TreeNode root = new TreeNode(postorder[postRight]);
        int rootInorder = inRight;
        while (rootInorder <= inRight && inorder[rootInorder] != root.val) { // 寻找root在前序遍历数组中的索引值
            rootInorder++;
        }

        int right = inRight - rootInorder;   // 右子树的个数
        root.right = build(postorder, inorder, postRight - 1, rootInorder + 1, inRight);
        root.left = build(postorder, inorder, postRight - right - 1, inLeft, rootInorder - 1);
        return root;
    }

    public TreeNode bfs_buildTree(int[] inorder, int[] postorder, int istart, int pend, int length) {
        if (length == 0) return null;

        TreeNode root = new TreeNode(postorder[pend - 1]);

        if (length == 1) return root;

        for (int i = length - 1; i >= 0; i--) {
            if (root.val == inorder[istart + i]) {
                root.left = bfs_buildTree(inorder, postorder, istart, pend - length + i, i);
                root.right = bfs_buildTree(inorder, postorder, istart + 1 + i, pend - 1, length - 1 - i);
                return root;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        ConstructFromInorderAndPostorder solution = new ConstructFromInorderAndPostorder();
        TreeNode res = solution.buildTree(inorder, postorder);
        System.out.println("res：" + res);
    }

}