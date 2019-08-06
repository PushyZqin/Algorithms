package nowcoder.judge_question;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/5/16 20:08
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int t = sc.nextInt();
            int a = sc.nextInt();

            int res = solution(n, t, a);
            System.out.println(res);
        }
    }

    private static int solution(int n, int t, int a) {
        if (t == a) return n;

        // 答对答案是√的题可能的最高分 + 答对答案是×的题可能的最高分
        return Math.min(t, a) + Math.min(n - t, n - a);
    }

}