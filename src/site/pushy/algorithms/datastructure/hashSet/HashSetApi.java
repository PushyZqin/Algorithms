package site.pushy.algorithms.datastructure.hashSet;

/**
 * @author Pushy
 * @since 2019/1/14 18:52
 */
public interface HashSetApi {

    void add(int key);

    void remove(int key);

    /** Returns true if this set contains the specified element */
    boolean contains(int key);

}
