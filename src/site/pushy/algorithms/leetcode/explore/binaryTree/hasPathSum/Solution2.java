package site.pushy.algorithms.leetcode.explore.binaryTree.hasPathSum;

import site.pushy.algorithms.leetcode.explore.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Pushy
 * @since 2019/1/27 15:54
 */
public class Solution2 {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();

            /* 当前节点为叶子，由于下面通过改变子结点的值，可以直接判断当前结点的值是否和目标和相等，
             如果相等，说明该路径所有结点相加的值等于目标和 */
            if (cur.left == null && cur.right == null) {
                if (cur.val == sum) return true;
            }

            if (cur.right != null) {
                cur.right.val += cur.val; // 改变右子结点的值 = 当前结点的值 + 右子结点的值
                queue.offer(cur.right);
            }

            if (cur.left != null) {
                cur.left.val += cur.val;  // 改变左子结点的值 = 当前结点的值 + 左子结点的值
                queue.offer(cur.left);
            }
        }
        return false;
    }

}
