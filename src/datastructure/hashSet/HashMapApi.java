package site.pushy.algorithms.datastructure.hashSet;

/**
 * @author Pushy
 * @since 2019/1/14 19:08
 */
public interface HashMapApi {

    /**
     * value will always be non-negative.
     * @param key
     * @param value
     */
    void put(int key, int value);

    /**
     * Returns the value to which the specified key is mapped
     * or -1 if this map contains no mapping for the key
     * @param key
     * @return
     */
    int get(int key);

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     * @param key
     */
    void remove(int key);

}
