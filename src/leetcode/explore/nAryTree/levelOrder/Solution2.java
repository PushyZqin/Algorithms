package site.pushy.algorithms.leetcode.explore.nAryTree.levelOrder;

import site.pushy.algorithms.leetcode.explore.nAryTree.Node;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/2/1 10:37
 */
public class Solution2 {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            while (size-- > 0) {
                Node node = queue.poll();
                level.add(node.val);
                if (node.children != null && node.children.size() != 0)
                    queue.addAll(node.children);
            }
            res.add(level);
        }
        return res;
    }

}