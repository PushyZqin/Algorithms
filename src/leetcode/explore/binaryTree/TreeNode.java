package site.pushy.algorithms.leetcode.explore.binaryTree;

/**
 * @author Pushy
 * @since 2019/1/26 12:13
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}
