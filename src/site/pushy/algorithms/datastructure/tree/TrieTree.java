package site.pushy.algorithms.datastructure.tree;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/2/1 14:02
 */
public class TrieTree implements TrieTreeApi {

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

    public TrieTree() {
        root = new Node(' ');
    }

    @Override
    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char v = word.charAt(i);
            Node newNode = node.children[v - 'a'];
            if (newNode == null) {  // 判断结点是否存在
                newNode = new Node(v);
                // v - 'a' 作为索引来查找数组中相应的子节点
                node.children[v - 'a'] = newNode;
            }
            node = newNode;
        }
        node.setEnd();
    }

    @Override
    public boolean search(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char v = word.charAt(i);
            node = node.children[v - 'a'];
            if (node == null) return false;
        }
        return node.isEnd;
    }

    @Override
    public boolean startsWith(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char v = prefix.charAt(i);
            node = node.children[v - 'a'];
            if (node == null) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        TrieTree trie = new TrieTree();

        trie.insert("apple");
        boolean res1 = trie.search("apple");   // 返回 true
        boolean res2 = trie.search("app");     // 返回 false
        boolean res3 = trie.startsWith("app"); // 返回 true

        trie.insert("app");
        boolean res4 = trie.search("app");     // 返回 true

        System.out.print(" " + res1 + " " + res2 + " " + res3 + " " + res4);
    }

}
