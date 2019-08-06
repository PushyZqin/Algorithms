package nowcoder.string_worth;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Pushy
 * @since 2019/5/17 19:48
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            int k = Integer.parseInt(sc.nextLine());

            int res = solution(s, k);
            System.out.println(res);
        }
    }

    private static int solution(String s, int k) {
        int[] arr = new int[26];
        for (char ch : s.toCharArray()) {
            arr[ch - 'a']++;
        }

        for (int i = 0; i < k; i++) {
            Arrays.sort(arr);
            arr[25]--;
        }

        int res = 0;
        for (int i = 0; i < 26; i++) {
            res += arr[i] * arr[i];
        }
        return res;
    }

}