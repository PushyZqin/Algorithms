package leetcode.explore.binaryTree.inorderTraversal;

import leetcode.explore.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 用迭代实现二叉树中序遍历
 *
 * @author Pushy
 * @since 2019/1/26 14:36
 */
public class Solution2 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) { // 遍历cur的左子结点，并将这些结点都压入栈中
                stack.push(cur);
                cur = cur.left;
            }
            // 出栈，访问这些子结点的右结点值
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        Solution2 solution = new Solution2();
        List<Integer> res = solution.inorderTraversal(root);
        System.out.println("res：" + res);
    }

}
