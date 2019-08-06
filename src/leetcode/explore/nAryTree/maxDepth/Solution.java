package site.pushy.algorithms.leetcode.explore.nAryTree.maxDepth;

import site.pushy.algorithms.leetcode.explore.nAryTree.Node;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/2/1 13:09
 */
public class Solution {

    public int maxDepth(Node root) {
        if (root == null) return 0;

        int max = 0;   //比较后返回最大值
        int ival = 0;  //记录每个结点的最大深度

        for (Node child : root.children) {
            ival = maxDepth(child);
            if (max < ival)
                max = ival;
        }
        return 1 + max;
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

        Solution2 solution = new Solution2();
//        offer.JumpFloorIII solution = new offer.JumpFloorIII();
        int res = solution.maxDepth(root);
        System.out.println("res：" + res);
    }

}