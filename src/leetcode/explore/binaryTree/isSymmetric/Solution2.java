package leetcode.explore.binaryTree.isSymmetric;

import leetcode.explore.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用队列迭代解决
 *
 * @author Pushy
 * @since 2019/1/27 10:49
 */
public class Solution2 {

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;  // 对比两个子树根结点的值

            /* 将t1的左子树和t2的右子树放入队列中对比 */
            queue.offer(t1.left);
            queue.offer(t2.right);
            /* 将t1的右子树和t2的左子树放入队列中对比 */
            queue.offer(t1.right);
            queue.offer(t2.left);
        }
        return true;
    }

}
