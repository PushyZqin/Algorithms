package site.pushy.algorithms.simple.tree;

import site.pushy.algorithms.leetcode.explore.binaryTree.TreeNode;

import java.util.Stack;

/**
 * 求二叉树的镜像，如：
 *
 *     1              1
 *    / \    =>      / \
 *   2   3          3   2
 *
 * @author Pushy
 * @since 2019/1/28 11:32
 */
public class BinaryTreeMirror {

    public static TreeNode solution(TreeNode root) {
        if (root == null) return root;

        /* 求左子树右子树的镜像 */
        TreeNode left = solution(root.right);
        TreeNode right = solution(root.left);

        /* 交换结点的左右子树 */
        root.left = left;
        root.right = right;

        return root;
    }

    public static void solution2(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur == null) continue;

            /* 交换左右子树 */
            TreeNode temp = cur.right;
            cur.right = cur.left;
            cur.left = temp;

            /* 将结点的左子树和右子树放入栈中，等待下次遍历的时候交换左右子树 */
            stack.push(cur.right);
            stack.push(cur.left);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        TreeNode result = BinaryTreeMirror.solution(root);
        System.out.println("res: " + result);

//        BinaryTreeMirror.solution2(root);
//        System.out.println(root.right.val);
    }

}