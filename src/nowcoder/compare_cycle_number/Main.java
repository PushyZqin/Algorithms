package nowcoder.compare_cycle_number;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/5/16 21:09
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int x1 = sc.nextInt(), k1 = sc.nextInt();
            int x2 = sc.nextInt(), k2 = sc.nextInt();

            String res = solution(x1, k1, x2, k2);
            System.out.println(res);
        }
    }

    private static String solution(int x1, int k1, int x2, int k2) {
        String v1 = repeat(x1, k1);
        String v2 = repeat(x2, k2);

        int l1 = v1.length(), l2 = v2.length();

        if (l1 < l2) return "Less";
        if (l1 > l2) return "Greater";

        for (int i = 0; i < l1; i++) {
            if (v1.charAt(i) > v2.charAt(i)) {
                return "Greater";
            }
            if (v1.charAt(i) < v2.charAt(i)) {
                return "Less";
            }
        }
        return "Equal";
    }

    static String repeat(int x, int k) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < k; i++) {
            res.append(x);
        }
        return res.toString();
    }

}