package leetcode.explore.bst.BSTIterator;

import leetcode.explore.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Pushy
 * @since 2019/1/30 17:34
 */
public class BSTIterator2 {

    // 二叉搜索树具有特殊性质，其中间节点的值大于左子节点的值，并且小于右子节点的值
    Queue<Integer> list = new LinkedList<>();

    public BSTIterator2(TreeNode root) {
        find(root);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return list.size() != 0;
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return list.poll();
    }

    private void find(TreeNode root) {
        if (root == null)
            return;

        find(root.left);
        list.offer(root.val);
        find(root.right);
    }

}
