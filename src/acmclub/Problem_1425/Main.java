package acmclub.Problem_1425;

import java.util.Scanner;

/**
 * @author Pushy
 * @since 2019/4/27 12:28
 */
public class Main {

    private static final String SUCCESS = "Mission Succeed";
    private static final String FAIL = "Try Again";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] arr = line.split(" ");
            long h = Long.parseLong(arr[0]);
            long a = Long.parseLong(arr[1]);
            long b = Long.parseLong(arr[2]);
            long k = Long.parseLong(arr[3]);

            if (h == 0 && a == 0 && b == 0 && k == 0) break;

            String res = solution(h, a, b, k);
            System.out.println(res);
        }
    }

    public static String solution(long h, long a, long b, long k) {
        if (a >= h) return SUCCESS;  // 秒杀
        if (b >= a) return FAIL;     // 回血大于攻击力，肯定杀不死

        // K个回合掉的血量 > 休息回合回血的量，BOSS肯定会over
        if ((a - b) * k > b) return SUCCESS;

        // 在未到达休息回合就over了
        if (h <= (a - b) * k) return SUCCESS;

        return FAIL;
    }

}
