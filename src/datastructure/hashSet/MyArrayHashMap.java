package datastructure.hashSet;

import java.util.Arrays;

/**
 * @author Pushy
 * @since 2019/1/14 19:09
 */
public class MyArrayHashMap implements HashMapApi {

    private int[] map;

    public MyArrayHashMap() {
        this.map = new int[100001];
        Arrays.fill(this.map, -1);
    }

    @Override
    public void put(int key, int value) {
        map[key] = value;
    }

    @Override
    public int get(int key) {
        return map[key];
    }

    @Override
    public void remove(int key) {
        map[key] = -1;
    }

    public static void main(String[] args) {
        MyArrayHashMap hashMap = new MyArrayHashMap();

        hashMap.put(1, 1);
        hashMap.put(2, 2);
        hashMap.get(1);            // 返回 1
        System.out.println(hashMap.get(3));            // 返回 -1 (未找到)
    }

}
