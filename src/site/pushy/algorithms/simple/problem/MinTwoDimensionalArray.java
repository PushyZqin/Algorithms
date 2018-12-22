package site.pushy.algorithms.simple.problem;

/**
 * 获取二维数组每列最小的值
 * 掌握遍历二维数组 arrays 的方法：
 * for (int i = 0; i < arrays.length; i++) {
 *     for (int j = 0; j < arrays[0].length; j++) {
 *         arrays[i][j]
 *     }
 * }
 *
 * @author Pushy
 * @since 2018/12/22 21:33
 */
public class MinTwoDimensionalArray {

    public static void solution(int[][] arrays) {
        int[] minArray = new int[arrays.length];

        for (int i = 0; i < arrays.length; i++) {  // 遍历列
            int min = arrays[i][0];   // 假设每列的第一位数是最小数
            for (int j = 0; j < arrays[0].length; j++) {  // 遍历每列中的行
                if (arrays[i][j] < min) {
                    min = arrays[i][j];
                }
            }
            minArray[i] = min;
        }

        // 打印每列的最小数
        for (int i = 0; i < minArray.length; i++) {
            System.out.println("第" + (i + 1) + "列的最小数为：" + minArray[i]);
        }
    }

    public static void main(String[] args) {
        int[][] arrays = {
                {23, 106, 8, 234},
                {25, 9, 73, 19},
                {56, 25, 67, 137}
        };

        MinTwoDimensionalArray.solution(arrays);
    }

}
