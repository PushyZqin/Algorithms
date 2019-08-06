package skill.sort;

import java.util.Arrays;

/**
 * @author Pushy
 * @since 2019/4/30 14:58
 */
public class HeapSort {

    /**
     * 从某个节点出发，开始调整堆的结构
     * @param tree 堆的底层数组结构
     * @param n    数组的长度
     * @param i
     */
    public void heapify(int[] tree, int n, int i) {
        if (i >= n) return;

        int left = 2 * i + 1;
        int right = 2 * i + 2;

        int max = i;  // 找到父节点、左结点、右结点较大的那个数的序号
        if (left < n && tree[left] > tree[max]) {
            max = left;
        }
        if (right < n && tree[right] > tree[max]) {
            max = right;
        }

        if (max != i) { // 交换
            swap(tree, max, i);
            heapify(tree, n, max);
        }
    }

    /**
     * 从一个打乱的完全二叉树构造成堆
     * @param tree
     * @param n
     */
    public void buildHeap(int[] tree, int n) {
        int last = n - 1;             // 最后一个结点
        int parent = (last - 1) / 2;  // 最后一个结点的父结点

        for (int i = parent; i >= 0; i--) {  // 从parent序号的结点开始倒着调用heapify
            heapify(tree, n, i);
        }
    }

    public void heapSort(int[] tree, int n) {
        buildHeap(tree, n);
        for (int i = n - 1; i >= 0; i--) {
            swap(tree, i, 0);     // 根结点与最后一个结点进行交换
            heapify(tree, i, 0);  // i代表当前剩余的结点数量
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();

        int[] tree = {4, 10, 3, 5, 1, 2};
        heapSort.heapify(tree, tree.length, 0);
        System.out.println(Arrays.toString(tree));

        int[] tree2 = {2, 5, 3, 1, 10, 4};
        heapSort.buildHeap(tree2, tree2.length);
        System.out.println(Arrays.toString(tree2));

        int[] arr = {4, 5, 3, 2, 6};
        heapSort.heapSort(arr, 5);
        System.out.println("arr = " + Arrays.toString(arr));
    }

}
