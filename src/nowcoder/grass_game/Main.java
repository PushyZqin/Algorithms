package nowcoder.grass_game;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/5/18 19:55
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String res = solution(sc.nextInt());
            System.out.println(res);
        }
    }

    private static String solution(int n) {
        if (n % 5 == 0 || n % 5 == 2) {
            return "yang";
        } else {
            return "niu";
        }
    }

}