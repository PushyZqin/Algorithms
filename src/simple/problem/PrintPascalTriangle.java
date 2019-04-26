package site.pushy.algorithms.simple.problem;

/**
 * 十行的杨辉三角打印如下：
 *   1
     1	1
     1	2	1
     1	3	3	1
     1	4	6	4	1
     1	5	10	10	5	1
     1	6	15	20	15	6	1
     1	7	21	35	35	21	7	1
     1	8	28	56	70	56	28	8	1
     1	9	36	84	126	126	84	36	9	1
 *
 * 它有如下的规律：
 * 1. 每行的第一个和最后一个都是1： 即第1列全部为1，第一行全都是1，当列数等于行数为1
 * 2. 当前值等于头上的值加头上的左边的值
 * 3. 第一行一列，第二行两列，第三行三列.......
 *
 * @author Pushy
 * @since 2018/12/22 22:03
 */
public class PrintPascalTriangle {

    public static void solution() {
        int[][] arrays = new int[10][];  // 打印一个十行的杨辉三角

        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = new int[i + 1];  // 初始化每一层的数组

            for (int j = 0; j <= i; j++) {
                /* 杨辉三角的特性，第一行，第一列，行数等于列数的元素都等于1 */
                if (i == 0 || j == 0 || j == i) {
                    arrays[i][j] = 1;
                } else {
                    /* 当前值等于头上的值 + 头上左边的值 */
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