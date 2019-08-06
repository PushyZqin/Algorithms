package datastructure.tree;

/**
 * 线段树的实现
 *
 * 【题目】给定一个数组arr，数组可能非常大。在程序运行过程中，你可能要做好几次query和update操作：
 *  query(arr, L, R) 表示计算数组arr中，从下标L到下标R之间的所有数字的和。
 *  update(arr, i, val) 表示要把arr[i]中的数字改成val。
 *
 * 怎样尽可能快地完成一系列query和update的操作？
 *
 * @author Pushy
 * @since 2019/4/30 11:20
 */
public class SegmentTree {

    /**
     * 构造线段树
     * @param arr   原始数组
     * @param tree  线段树数据结构，用一个数组来实现
     * @param node  指向tree数组的索引值
     * @param start 区间开始下标
     * @param end   区间结束下标
     */
    public static void buildTree(int[] arr, int[] tree, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;  // 中间值
            int left = 2 * node + 1;      // 左结点序号
            int right = 2 * node + 2;     // 右结点序号

            buildTree(arr, tree, left, start, mid);
            buildTree(arr, tree, right, mid + 1, end);

            tree[node] = tree[left] + tree[right];
        }
    }

    /**
     * 更新线段树
     * @param arr   原始数组
     * @param tree  线段树数据结构，用一个数组来实现
     * @param node  指向tree数组的索引值
     * @param start 区间开始下标
     * @param end   区间结束下标
     * @param idx   需要修改的元素在原数组的下标
     * @param val   需要修改成的值
     */
    public static void updateTree(int[] arr, int[] tree, int node, int start, int end, int idx, int val) {
        if (start == end) {  // 到达叶子
            arr[idx] = val;
            tree[node] = val;
        } else {
            int mid = (start + end) / 2; // 中间值
            int left = 2 * node + 1;     // 左结点序号
            int right = 2 * node + 2;    // 右结点序号

            if (idx >= start && idx <= mid) {
                updateTree(arr, tree, left, 0, mid, idx, val);
            } else {
                updateTree(arr, tree, right, mid + 1, end, idx, val);
            }
            tree[node] = tree[left] + tree[right];  // 子结点更新过，需要更新父结点的值
        }
    }

    /**
     * 查询线段树
     * @param arr   原始数组
     * @param tree  线段树数据结构，用一个数组来实现
     * @param node  指向tree数组的索引值
     * @param start 区间开始下标
     * @param end   区间结束下标
     * @param L
     * @param R
     */
    public static int queryTree(int[] arr, int[] tree, int node, int start, int end, int L, int R) {
        if (R < start || L > end) // 不在计算区间内
            return 0;

        if (L <= start && R >= end) // 当前结点的区间在目标区间内，直接返回该结点值即可
            return tree[node];

        int mid = (start + end) / 2; // 中间值
        int left = 2 * node + 1;     // 左结点序号
        int right = 2 * node + 2;    // 右结点序号

        int sumLeft = queryTree(arr, tree, left, start, mid, L, R);
        int sumRight = queryTree(arr, tree, right, mid + 1, end, L, R);

        // 返回左右子树区间相加的值即可
        return sumLeft + sumRight;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        int size = arr.length;

        int[] tree = new int[1000];

        buildTree(arr, tree, 0, 0, size - 1);

        for (int i = 0; i < 15; i++) {
            System.out.println(String.format("tree[%d] = %d", i, tree[i]));
        }

        updateTree(arr, tree, 0, 0, size - 1, 4, 6);

        System.out.println("");
        for (int i = 0; i < 15; i++) {
            System.out.println(String.format("tree[%d] = %d", i, tree[i]));
        }

        int sum = queryTree(arr, tree, 0, 0, size - 1, 2, 5);
        System.out.println("sum = " + sum);
    }

}
