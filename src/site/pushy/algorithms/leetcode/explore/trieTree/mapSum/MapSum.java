package site.pushy.algorithms.leetcode.explore.trieTree.mapSum;

/**
 * @author Pushy
 * @since 2019/2/2 9:37
 */
public class MapSum {

    class Node {
        char v;           // 当前节点的值
        boolean isEnd;    // 标识此节点是否为某个单词的结束节点
        Node[] children;  // 大小为26的数组来存储其子节点，并可以使用 v - 'a' 作为索引来查找数组中相应的子节点

        public Node(char v) {
            this.v = v;
            children = new Node[26];
        }

        public void setEnd() {
            this.isEnd = true;
        }
    }

    Node root;

    /** Initialize your data structure here. */
    public MapSum() {
        root = new Node(' ');
    }

    public void insert(String key, int val) {
        Node node = root;

    }

    public int sum(String prefix) {
        return -1;
    }



}
