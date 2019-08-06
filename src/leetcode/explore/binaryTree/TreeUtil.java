package leetcode.explore.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Pushy
 * @since 2019/4/27 10:00
 */
public class TreeUtil {

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) return null;

        StringBuilder res = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                res.append(cur.val).append(",");
                queue.add(cur.left);
                queue.add(cur.right);
            } else {
                res.append("null,");
            }
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;

        String[] array = data.split(",");
        int idx = 0;

        TreeNode root = toNode(array[idx]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (idx < array.length - 2 && !queue.isEmpty()) {
            TreeNode cur = queue.poll();

            TreeNode left = toNode(array[++idx]);
            cur.left = left;
            if (left != null) queue.offer(left);

            TreeNode right = toNode(array[++idx]);
            cur.right = right;
            if (right != null) queue.offer(right);
        }
        return root;
    }

    private static TreeNode toNode(String val) {
        if (!val.equals("null")) {
            return new TreeNode(Integer.parseInt(val));
        } else {
            return null;
        }
    }

}
