package leetcode.explore.binaryTree.buildTree;

import leetcode.explore.binaryTree.TreeNode;

/**
 * @author Pushy
 * @since 2019/5/22 9:36
 */
public class ConstructFromPreorderAndInorder {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder,
                                     int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) return null;

        TreeNode root = new TreeNode(preorder[preLeft]);

        int rootInorder = inLeft;  // 找到中序遍历中的根节点
        while (rootInorder <= inRight && preorder[preLeft] != inorder[rootInorder]) {
            rootInorder++;
        }

        int left = rootInorder - inLeft;  // 左子树的个数
        root.left = buildTreeHelper(preorder, inorder, preLeft + 1, preLeft + left, inLeft, rootInorder - 1);
        root.right = buildTreeHelper(preorder, inorder, preLeft + left + 1, preRight, rootInorder + 1, inRight);

        return root;
    }

    public static void main(String[] args) {
        
    }

}
