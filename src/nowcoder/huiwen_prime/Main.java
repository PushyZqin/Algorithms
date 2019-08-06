package nowcoder.huiwen_prime;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/5/17 10:20
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int L = sc.nextInt(), R = sc.nextInt();

            int res = solution(L, R);
            System.out.println(res);
        }
    }

    private static int solution(int L, int R) {
        Set<Integer> set =
                new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 101, 131, 151, 181, 191, 313, 353, 373, 383, 727, 757, 787, 797, 919, 929));

        int res = 0;
        for (int i = L; i <= R; i++) {
            if (set.contains(i) && isPalindrome(i)) {
                res++;
            }
        }
        return res;
    }

    private static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revert = 0;
        while (x > revert) {
            revert = revert * 10 + x % 10;
            x /= 10;
        }
        return x == revert || x == revert / 10;
    }

}