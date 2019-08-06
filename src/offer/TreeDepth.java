package offer;

import leetcode.explore.binaryTree.TreeNode;
import leetcode.explore.binaryTree.TreeUtil;

import java.util.LinkedList;
import java.util.Queue;

public class TreeDepth {

    /**
     * 递归实现
     * @param root
     * @return
     */
    public int TreeDepth(TreeNode root) {
        return getDepth(root, 0);
    }

    private int getDepth(TreeNode root, int depth) {
        if (root == null) return depth;

        int left = getDepth(root.left, depth + 1);
        int right = getDepth(root.right, depth + 1);

        return Math.max(left, right);
    }

    // 简洁一点的写法
//    public int TreeDepth(TreeNode root) {
//        if (root == null) return 0;
//
//        int left = TreeDepth(root.left);
//        int right = TreeDepth(root.right);
//
//        return left > right ? left + 1 : right + 1;
//    }

    // 遍历实现
    public int TreeDepthTraversal(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.deserialize("1,2,3,4,5");
        TreeDepth s = new TreeDepth();
        System.out.println(s.TreeDepthTraversal(root));
    }

}
