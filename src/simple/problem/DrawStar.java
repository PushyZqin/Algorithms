package simple.problem;

/**
 * 画星星，如下图：
 *
 *                    *
 *                   ***
 *                  ******
 *                 ********
 *
 * @author Pushy
 * @since 2018/12/25 10:55
 */
public class DrawStar {

    public static void solution() {
        int line = 4;
        for (int i = 1; i < line + 1; i++) {
            int startCount = (2 * i) - 1;  // 星星的个数

            for (int j = 0; j < line - i; j++) {  // 填充空格
                System.out.print(" ");
            }

            for (int j = 0; j < startCount; j++) {  // 填充星星
                System.out.print("*");
            }

            System.out.println();  // 换行
        }
    }

    public static void main(String[] args) {
        DrawStar.solution();
    }

}