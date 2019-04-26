package site.pushy.algorithms.datastructure.linkedList;

/**
 * @author LeetCode
 */
public interface LinkedListInterface {

    /**
     * Get the value of the index-th node in the linked list.
     * If the index is invalid, return -1.
     *
     * @param index
     */
    int get(int index);

    /**
     * Add a node of value val before the first element of the linked list.
     * After the insertion, the new node will be the first node of the linked list.
     *
     * @param val
     */
    void addAtHead(int val);

    /**
     * Append a node of value val to the last element of the linked list.
     *
     * @param val
     */
    void addAtTail(int val);

    /**
     * Add a node of value val before the index-th node in the linked list
     * If index equals to the length of linked list, the node will be appended to the end of linked list.
     * If index is greater than the length, the node will not be inserted.
     *
     * @param index
     * @param val
     */
    void addAtIndex(int index, int val);

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    void deleteAtIndex(int index);

}
