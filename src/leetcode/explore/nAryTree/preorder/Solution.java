package site.pushy.algorithms.leetcode.explore.nAryTree.preorder;

import site.pushy.algorithms.leetcode.explore.nAryTree.Node;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/2/1 10:53
 */
public class Solution {

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        preorderHelper(root, res);
        return res;
    }

    public void preorderHelper(Node root, List<Integer> res) {
        if (root == null) return;

        res.add(root.val);
        for (Node child : root.children) {
            preorderHelper(child, res);
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

//        Main solution = new Main();
        Solution2 solution = new Solution2();
        List<Integer> res = solution.preorder(root);
        System.out.println("res：" + res);
    }

}