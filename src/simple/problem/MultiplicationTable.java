package site.pushy.algorithms.simple.problem;

/**
 * 打印乘法口诀表
 *
 * @author Pushy
 * @since 2018/12/22 19:15
 */
public class MultiplicationTable {

    public static void main(String[] args) {
        System.out.println("打印99乘法口诀表：\n");

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%d * %d = %d \t", i, j, i * j);
                if (j == i) {  // 换行，例如当 2 * 2 = 4 时
                    System.out.println();
                }
            }
        }
    }

}
