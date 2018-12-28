package site.pushy.algorithms.simple.array;

/**
 * 数组对角线元素之和
 *
 * @author Pushy
 * @since 2018/12/22 21:58
 */
public class ArrayDiagonalSum {

    public static void solution(int[][] arrays) {
        int sum = 0;
        for (int i = 0; i < arrays.length; i++) {
            sum += arrays[i][i];  // 只要行和列相等，即是对角线的元素
        }

        System.out.println("数组的对角线之和为： " + sum);
    }

    public static void main(String[] args) {
        int[][] arrays = {
                {23, 106, 8, 234},
                {25, 9, 73, 19},
                {56, 25, 67, 137},
                {33, 22, 11, 44},
        };
        ArrayDiagonalSum.solution(arrays);
    }

}