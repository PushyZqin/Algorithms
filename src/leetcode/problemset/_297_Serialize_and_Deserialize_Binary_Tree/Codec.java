package leetcode.problemset._297_Serialize_and_Deserialize_Binary_Tree;

import leetcode.explore.binaryTree.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Pushy
 * @since 2019/4/30 10:22
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
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
    public TreeNode deserialize(String data) {
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

    private TreeNode toNode(String val) {
        if (!val.equals("null")) {
            return new TreeNode(Integer.parseInt(val));
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        Codec codec = new Codec();

        String s = codec.serialize(root);
        System.out.println(s);

        root = codec.deserialize("1,2,3,null,null,4,5");
        System.out.println(root.right.left);
    }

}
