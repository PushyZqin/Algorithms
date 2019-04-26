package site.pushy.algorithms.leetcode.explore.trieTree.wordDictionary;

/**
 * @author Pushy
 * @since 2019/2/2 17:41
 */
public class WordDictionary {

    class TrieNode {
        char v;
        boolean isEnd;
        TrieNode[] children = new TrieNode[26];

        public TrieNode(char v) {
            this.v = v;
        }
    }

    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new TrieNode(' ');
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode newNode = node.children[c - 'a'];
            if (newNode == null) {
                newNode = new TrieNode(c);
                node.children[c - 'a'] = newNode;
            }
            node = newNode;
        }
        node.isEnd = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return searchHelper(root, word, 0);
    }

    private boolean searchHelper(TrieNode node, String word, int index) {
        if (index == word.length()) return node.isEnd;
        char c = word.charAt(index);

        if (c == '.') {
            // 回溯该节点所有分支
            for (TrieNode temp : node.children) {
                if (temp != null && searchHelper(temp, word, index + 1))
                    return true;
            }
            return false;
        } else {
            TrieNode temp = node.children[c - 'a'];
            return temp != null && searchHelper(temp, word, index + 1);
        }
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("pad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");

        boolean res1 = wordDictionary.search("pad");
        boolean res2 = wordDictionary.search("bad");
        boolean res3 = wordDictionary.search(".ad");
        boolean res4 = wordDictionary.search("b..");

        System.out.println(" " + res1 + " " + res2 + " " + res3 + " " + res4);
    }

}
