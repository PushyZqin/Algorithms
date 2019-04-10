package site.pushy.algorithms.leetcode.explore.queueStack.cloneGraph;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
    }

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

/**
 * @author Pushy
 * @since 2019/4/2 17:20
 */
public class Solution {

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> map = new HashMap<>();

        Node head = new Node(node.val, new ArrayList<>()); // 新克隆的图头结点
        map.put(node, head);
        dfsSearch(map, node);

        return head;
    }

    private void dfsSearch(Map<Node, Node> map, Node node) {
        if (node == null) return;
        for (Node neighbor : node.neighbors) {
            if (!map.containsKey(neighbor)) {
                Node newNeighbor = new Node(neighbor.val, new ArrayList<>());
                map.put(neighbor, newNeighbor);
                dfsSearch(map, neighbor);
            }
            map.get(node).neighbors.add(map.get(neighbor));
        }
    }

    public static void main(String[] args) {
        Node node = new Node();

        Solution solution = new Solution();
        Node res = solution.cloneGraph(node);
        System.out.println("res：" + res);
    }

}