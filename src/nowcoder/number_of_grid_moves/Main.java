package nowcoder.number_of_grid_moves;

import java.util.Scanner;

/**
 * @author Pushy
 * @since 2019/4/24 11:20
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] params = line.split(" ");

        int x = Integer.parseInt(params[0]);
        int y = Integer.parseInt(params[1]);
        int res = solution(x, y);
        System.out.println(res);
    }

    public static int solution(int x, int y) {
        return dfs(0, 0, x, y, 0);
    }

    public static int dfs(int x, int y, int targetX, int targetY, int cnt) {
        if (x == targetX && y == targetY) {  // 到达目标点
            cnt++;
            return cnt;
        }

        for (int i = 0; i < 2; i++) { // 循环往右和往下走
            int nextX, nextY;
            if (i == 0) { // 往下走
                nextX = x + 1;
                nextY = y;
            } else { // 往右走
                nextX = x;
                nextY = y + 1;
            }
            if (nextX <= targetX && nextY <= targetY) { // 校验是否是合理的坐标值
                cnt = dfs(nextX, nextY, targetX, targetY, cnt);
            }
        }
        return cnt;
    }

}
