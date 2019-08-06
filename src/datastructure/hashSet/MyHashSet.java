package datastructure.hashSet;

/**
 * @author Pushy
 * @since 2019/1/14 18:58
 */
public class MyHashSet implements HashSetApi {

    private boolean[] dataSet;

    public MyHashSet() {
        dataSet = new boolean[100001];
    }

    @Override
    public void add(int key) {
        dataSet[key] = true;
    }

    @Override
    public void remove(int key) {
        dataSet[key] = false;
    }

    @Override
    public boolean contains(int key) {
        return dataSet[key];
    }
}
