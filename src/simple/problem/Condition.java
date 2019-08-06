package simple.problem;

import java.util.Scanner;

/**
 * 条件运算符的使用：  (a > b) ? result1[when a > b] : result2[when a < b]
 *
 * @author Pushy
 * @since 2018/12/22 20:58
 */
public class Condition {

    public static void solution(int score) {
        String str = score >= 90 ? "A" : (score < 60 ? "C" : "B");
        System.out.println(str);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的成绩：");

        Integer score = Integer.parseInt(scanner.nextLine());

        solution(score);
    }

}
