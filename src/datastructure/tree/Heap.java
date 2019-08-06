package datastructure.tree;

import java.util.Arrays;

/**
 * @author Pushy
 * @since 2019/4/30 14:58
 */
public class Heap {

    public void heapify(int[] tree, int n, int i) {
        if (i >= n) return;

        int left = 2 * i + 1;
        int right = 2 * i + 2;

        int max = i;
        if (left < n && tree[left] > tree[i]) {
            max = left;
        }
        if (right < n && tree[right] > tree[i]) {
            max = right;
        }

        if (max != i) { // 交换
            swap(tree, max, i);
            heapify(tree, n, max);
        }
    }

    public void buildHeap(int[] tree, int n) {
        int last = n - 1;
        int parent = (last - 1) / 2;

        for (int i = parent; i >= 0; i--) {
            heapify(tree, n, i);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] tree = {4, 10, 3, 5, 1, 2};
        int size = tree.length;

        Heap heapSort = new Heap();
        heapSort.heapify(tree, size, 0);

        System.out.println(Arrays.toString(tree));

        int[] tree2 = {1, 2, 5, 3, 10, 4};
        heapSort.buildHeap(tree2, tree2.length);
        System.out.println(Arrays.toString(tree2));
    }

}
