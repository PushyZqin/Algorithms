package site.pushy.algorithms.simple.tree;

import site.pushy.algorithms.leetcode.explore.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 判断两棵二叉树是否相同的树
 *
 * @author Pushy
 * @since 2019/1/28 10:54
 */
public class IsSameTree {

    public static boolean solution(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null)  // 两树均为空，返回true
            return true;
        if (r1 == null || r2 == null)  // 一个为空，一个不为空，返回false
            return false;

        if (r1.val != r2.val)          // 两树根结点值不相同，返回false
            return false;

        /* 递归调用，保证r1的左子树和r2的左子树相等，r1的右子树和r2的右子树相等 */
        return solution(r1.left, r2.left) && solution(r1.right, r2.right);
    }

    /**
     * 迭代解决，基于层次遍历进行求解
     */
    public static boolean solution2(TreeNode r1, TreeNode r2) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(r1);
        queue.offer(r2);

        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;  // 两树根结点的值不相同

            /* 将树r1与树r2的左子树放入队列中，待下次遍历比较 */
            queue.offer(t1.left);
            queue.offer(t2.left);

            /* 将树r1与树r2的右子树放入队列中，待下次遍历比较 */
            queue.offer(t1.right);
            queue.offer(t2.right);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(3);
        r1.left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);
        r1.right = right;

        TreeNode r2 = new TreeNode(3);
        r2.left = new TreeNode(9);
        TreeNode right2 = new TreeNode(20);
        right2.left = new TreeNode(15);
        right2.right = new TreeNode(7);
        r2.right = right2;

        boolean result = IsSameTree.solution2(r1, r2);
        System.out.println("res: " + result);
    }

}