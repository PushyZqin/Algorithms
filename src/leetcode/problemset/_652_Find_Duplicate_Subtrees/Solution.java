package leetcode.problemset._652_Find_Duplicate_Subtrees;

import leetcode.explore.binaryTree.TreeNode;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/4/22 12:24
 */
public class Solution {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> map = new HashMap<>();
        List<TreeNode> res = new ArrayList<>();

        postorder(root, res, map);
        System.out.println(map);
        System.out.println(res);
        return res;
    }

    /**
     * 后序遍历，将路径作为map的key，路径的出现次数作为value
     */
    private String postorder(TreeNode root, List<TreeNode> res, Map<String, Integer> map) {
        if (root == null) return "#";

        String leftPath = postorder(root.left, res, map);
        String rightPath = postorder(root.right, res, map);
        String path = root.val + leftPath + rightPath;

        if (map.getOrDefault(path, 0) == 1)
            res.add(root);
        map.put(path, map.getOrDefault(path, 0) + 1);
        return path;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);

        root.right.left.left = new TreeNode(4);

        Solution solution = new Solution();
        List<TreeNode> res = solution.findDuplicateSubtrees(root);
        System.out.println("res：" + res);
    }

}