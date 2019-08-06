package acmclub.Problem_1364;

import java.util.Scanner;

/**
 * @author Pushy
 * @since 2019/4/27 11:31
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            int n = Integer.parseInt(line);
            if (n == 0) break;

            int res = solution(n);
            System.out.println(res);
        }
    }

    public static int solution(int n) {
        int emptyCnt = n, fullCnt = 0;
        int res = 0;

        while (emptyCnt != 0) {
            if (emptyCnt >= 3) { // 手中空瓶 >= 3
                int cnt = emptyCnt / 3;
                emptyCnt %= 3;
                fullCnt += cnt;

                if (fullCnt != 0) {
                    emptyCnt += fullCnt;
                    res += fullCnt;
                    fullCnt = 0;
                }
            } else if (emptyCnt == 2){ // 手中剩余空瓶数 = 2，可以向老板借一个空瓶，然后再归还一个空瓶
                res++;
                break;
            } else {  // 手中剩余的空瓶数 <= 2，无法再借空瓶还了
                break;
            }
        }
        return res;
    }

}
