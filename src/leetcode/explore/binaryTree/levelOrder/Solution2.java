package leetcode.explore.binaryTree.levelOrder;

import leetcode.explore.binaryTree.TreeNode;

import java.util.*;

/**
 * 递归实现层序遍历，实际上是广度优先搜索
 *
 * @author Pushy
 * @since 2019/4/29 10:47
 */
public class Solution2 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        handleLevelOrder(root, res, 0);
        return res;
    }

    private void handleLevelOrder(TreeNode root, List<List<Integer>> res, int depth) {
        if (root == null) return;

        if (depth >= res.size()) {
            res.add(new ArrayList<>());
        }

        res.get(depth).add(root.val);

        if (root.left != null) {
            handleLevelOrder(root.left, res, depth + 1);
        }
        if (root.right != null) {
            handleLevelOrder(root.right, res, depth + 1);
        }
    }

}
