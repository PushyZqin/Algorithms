package site.pushy.algorithms.leetcode.explore.queueStack.inorderTraversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的中序遍历
 * 原题地址：https://leetcode-cn.com/explore/learn/card/queue-stack/219/stack-and-dfs/887/
 *
 * @author Pushy
 * @since 2018/111/13 20:02
 */
public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            this.val = x;
        }
    }

    /**
     * 采用非递归的方式实现二叉树的中序遍历
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode pointer = root;
        while (pointer != null || !stack.isEmpty()) {
            if (pointer != null) { // 如果当前节点不为空，则将当前节点放入栈中
                stack.push(pointer);
                pointer = pointer.left;  // 继续访问当前节点的左节点
            } else {  // 如果当前节点为空，则取出栈顶元素，并打印该栈顶元素（说明栈顶元素的节点无左节点了）
                pointer = stack.pop();
                res.add(pointer.val);  // 遍历该元素
                pointer = pointer.right;  // 访问右节点
            }
        }
        return res;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> res = solution.inorderTraversal(root);
        System.out.println("res = " + res);
    }

}
