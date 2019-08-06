package simple.tree;

import leetcode.explore.binaryTree.TreeNode;

import java.util.Stack;

/**
 * 求二叉树的镜像，要求不能破坏原来的树结构，如：
 *
 *     1              1
 *    / \    =>      / \
 *   2   3          3   2
 *
 *                  新的树
 * @author Pushy
 * @since 2019/1/28 11:53
 */
public class BinaryTreeMirror2 {

    public static TreeNode solution(TreeNode root) {
        if (root == null) return root;

        /* 当该结点不为空时，创建新的节点（与该结点值相同） */
        TreeNode newRoot = new TreeNode(root.val);

        /* 将新结点的左子树为root的右子树，新结点的右子树为root左子树 */
        newRoot.left = solution(root.right);
        newRoot.right = solution(root.left);

        return newRoot;
    }

    public static TreeNode solution2(TreeNode root) {
        if (root == null) return root;

        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> newStack = new Stack<>();
        TreeNode newRoot = new TreeNode(root.val);

        stack.push(root);
        newStack.push(newRoot);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            TreeNode newCur = newStack.pop();

            if (cur.right != null) {
                stack.push(cur.right);
                newCur.right = new TreeNode(cur.left.val);
                newStack.push(newCur.left);
            }
            if (cur.left != null) {
                stack.push(cur.left);
                newCur.left = new TreeNode(cur.right.val);
                newStack.push(newCur.right);
            }
        }

        return newRoot;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        TreeNode result = BinaryTreeMirror2.solution2(root);
        System.out.println("res: " + result.right);
    }

}