package nowcoder.DNA_sequence;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/5/16 20:21
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            int res = solution(s);
            System.out.println(res);
        }
    }

    private static int solution(String s) {
        Set<String> set = new HashSet<>();

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= s.length() - i; j++) {
                set.add(s.substring(j, j + i));
            }
            if (set.size() < (int) Math.pow(4, i)) {  // 比较i长度的{A, C, G, T}全排列的个数
                return i;
            }
            set.clear();
        }
        return -1;
    }

}