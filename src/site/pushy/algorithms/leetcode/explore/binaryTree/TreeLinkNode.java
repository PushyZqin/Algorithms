package site.pushy.algorithms.leetcode.explore.binaryTree;

/**
 * @author Pushy
 * @since 2019/1/30 10:33
 */
public class TreeLinkNode {

    public int val;
    public TreeLinkNode left;
    public TreeLinkNode right;
    public TreeLinkNode next;

    public TreeLinkNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeLinkNode{" +
                "val=" + val +
                '}';
    }
}
