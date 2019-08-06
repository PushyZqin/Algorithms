package nowcoder.delete_dup_char;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/5/16 19:42
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String res = solution(str);
            System.out.println(res);
        }
    }

    private static String solution(String str) {
        int[] arr = new int[26];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            if (arr[idx] == 0)
                sb.append(str.charAt(i));
            arr[idx] += 1;
        }
        return sb.toString();
    }

}