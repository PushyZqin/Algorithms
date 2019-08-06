package datastructure.tree;

/**
 * @author Pushy
 * @since 2019/2/1 14:02
 */
public interface TrieTreeApi {

    /** Inserts a word into the trie. */
    void insert(String word);

    /** Returns if the word is in the trie. */
    boolean search(String word);

    /** Returns if there is any word in the trie that starts with the given prefix. */
    boolean startsWith(String prefix);

}
