package site.pushy.algorithms.leetcode.explore.binaryTree.serialize;

import site.pushy.algorithms.leetcode.explore.binaryTree.TreeNode;

/**
 * @author Pushy
 * @since 2019/1/29 21:29
 */
public class Solution {

    /**
     * 序列化
     */
    public String serialize(TreeNode root) {
//        Stack<TreeNode> stack = new Stack<>();
//        StringBuilder sb = new StringBuilder();
//
//        sb.append("[");
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            TreeNode node = stack.pop();
//            if (node == null) {
//                sb.append("null").append(",");
//            } else {
//                sb.append(node.val).append(",");
//                stack.push(node.right);
//                stack.push(node.left);
//            }
//        }
//        sb.append("]");
//        return sb.toString();
        StringBuilder sb = new StringBuilder();
        serializeCode(root, sb);
        return sb.toString();
    }

    public void serializeCode(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null").append(",");
            return;
        }
        sb.append(root.val).append(",");
        serializeCode(root.left, sb);
        serializeCode(root.right, sb);
    }

    /**
     * 反序列化
     */
    public TreeNode deserialize(String data) {
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String data = "[1,2,3,null,null,4,5]";

        Solution solution = new Solution();
        String res = solution.serialize(root);
        TreeNode res2 = solution.deserialize(data);

        System.out.println("res：" + res);
        System.out.println("root：" + res2);
    }

}