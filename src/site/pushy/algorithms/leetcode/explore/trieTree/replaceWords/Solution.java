package site.pushy.algorithms.leetcode.explore.trieTree.replaceWords;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/2/2 9:48
 */
public class Solution {

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

    public String replaceWords(List<String> dict, String sentence) {
        root = new Node(' ');
        createRoot(dict);

        StringBuilder res = new StringBuilder();
        for (String str : sentence.split(" ")) {
            res.append(" ").append(prefix(str));
        }
        return res.toString().trim();
    }

    private String prefix(String word) {
        Node node = root;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char v = word.charAt(i);
            builder.append(v);
            node = node.children[v - 'a'];
            if (node == null)
                return word;
            else if (node.isEnd)
                return builder.toString();
        }
        return word;
    }

    private void createRoot(List<String> dict) {
        for (String word : dict) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                char v = word.charAt(i);
                Node newNode = node.children[v - 'a'];
                if (newNode == null) {  // 判断结点是否存在
                    newNode = new Node(v);
                    node.children[v - 'a'] = newNode;
                }
                node = newNode;
            }
            node.setEnd();
        }
    }

    public static void main(String[] args) {
        List<String> dict = Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";

//        List<String> dict = Arrays.asList("a", "aa", "aaa", "aaaa");
//        String sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa";

        Solution solution = new Solution();
        String res = solution.replaceWords(dict, sentence);
        System.out.println("res：" + res);
    }

}