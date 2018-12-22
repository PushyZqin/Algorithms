package site.pushy.algorithms.simple.problem;

/**
 * @author Pushy
 * @since 2018/12/22 22:03
 */
public class PrintPascalTriangle {

    public static void solution() {
        int[][] arrays = new int[10][];  // 打印一个十行的杨辉三角

        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = new int[i + 1];  // 初始化每一层的数组

            for (int j = 0; j <= i; j++) {
                // 杨辉三角的特性，第一行，第一列，行数等于列数的元素都等于1
                if (i == 0 || j == 0 || j == i) {
                    arrays[i][j] = 1;
                } else {
                    // 当前值等于头上的值 + 头上左边的值
                    arrays[i][j] = arrays[i - 1][j] + arrays[i - 1][j - 1];
                }
            }
        }

        System.out.println("打印出杨辉三角：");

        for (int[] array : arrays) {
            for (int value : array) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        PrintPascalTriangle.solution();
    }

}