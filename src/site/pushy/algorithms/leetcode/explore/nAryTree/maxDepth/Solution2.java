package site.pushy.algorithms.leetcode.explore.nAryTree.maxDepth;

import site.pushy.algorithms.leetcode.explore.nAryTree.Node;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/2/1 13:09
 */
public class Solution2 {

    public int maxDepth(Node root) {
        if (root == null) return 0;

        Queue<Node> queue = new LinkedList<>();
        int res = 0;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Node node = queue.poll();
                queue.addAll(node.children);
            }
            res++;
        }
        return res;
    }

}