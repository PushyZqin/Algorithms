package nowcoder.childrens_day;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Pushy
 * @since 2019-5-8 15:00:49
 * @question https://www.nowcoder.com/practice/d2dfc62bf1ba42679a0e358c57da9828
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int[] h = new int[N];
            for (int i = 0; i < N; i++) {
                h[i] = scanner.nextInt();
            }
            int M = scanner.nextInt();
            int[] w = new int[M];
            for (int i = 0; i < M; i++) {
                w[i] = scanner.nextInt();
            }

            int res = solution(h, w);
            System.out.println(res);
        }
    }

    private static int solution(int[] h, int[] w) {
        Arrays.sort(w);
        int res = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < h.length; i++) {
            for (int j = 0; j < w.length; j++) {
                if (h[i] <= w[j] && !set.contains(j)) {
                    set.add(j);
                    res++;
                    break;
                }
            }
        }

        return res;
    }

    /**
     * 贪心算法，先将两个数组都排序，然后吃的最少的小朋友先选重量最小的巧克力，依次往后
     * @param h
     * @param w
     * @return
     */
    private static int solution2(int[] h, int[] w) {
        Arrays.sort(h);
        Arrays.sort(w);

        int i = 0, j = 0, res = 0;
        while (j < w.length && i < h.length) {
            if (h[i] <= w[j]) {
                res++;
                i++;
                j++;
            } else { // 没有符合小朋友的重量巧克力
                j++;
            }
        }
        return res;
    }

}