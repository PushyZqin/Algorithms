package site.pushy.algorithms.leetcode.explore.nAryTree;

import java.util.List;

/**
 * N叉树结点结构
 *
 * @author Pushy
 * @since 2019/2/1 10:37
 */
public class Node {

    public int val;                // 当前结点的值
    public List<Node> children;    // 子结点集合

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

}
