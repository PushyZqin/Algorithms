package site.pushy.algorithms.leetcode.explore.nAryTree.postorder;

import site.pushy.algorithms.leetcode.explore.nAryTree.Node;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/2/1 11:20
 */
public class Solution {

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        postorderHelper(root, res);
        return res;
    }

    public void postorderHelper(Node root, List<Integer> res) {
        if (root == null) return;

        for (Node child : root.children) {
            postorderHelper(child, res);
        }
        res.add(root.val);
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
        List<Integer> res = solution.postorder(root);
        System.out.println("res：" + res);
    }

}