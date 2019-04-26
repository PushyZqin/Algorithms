package site.pushy.algorithms.leetcode.explore.nAryTree.levelOrder;

import site.pushy.algorithms.leetcode.explore.nAryTree.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Pushy
 * @since 2019/2/1 10:48
 */
public class Solution {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        addList(0, root, res);
        return res;
    }

    public void addList(int level, Node nodes, List<List<Integer>> res) {
        if (nodes == null) return;

        if (res.size() - 1 < level) res.add(new ArrayList<>());

        res.get(level).add(nodes.val);
        for (Node node : nodes.children) {
            addList(level + 1, node, res);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        List<Node> secondLevel = new ArrayList<>();
        Node left = new Node(3);
        left.children = Arrays.asList(new Node(5, new ArrayList<>()), new Node(6, new ArrayList<>()));
        secondLevel.add(left);
        secondLevel.add(new Node(2, new ArrayList<>()));
        secondLevel.add(new Node(4, new ArrayList<>()));
        root.children = secondLevel;

        Solution solution = new Solution();
//        Main solution = new Main();
        List<List<Integer>> res = solution.levelOrder(root);
        System.out.println("res：" + res);
    }

}
