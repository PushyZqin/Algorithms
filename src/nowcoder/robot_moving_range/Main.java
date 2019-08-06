package nowcoder.robot_moving_range;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Pushy
 * @since 2019/5/7 10:49
 */
public class Main {

    private static int result = 0;

    private static final Integer[][] next = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] strs = line.split(" ");
            int m = Integer.parseInt(strs[0]);
            int n = Integer.parseInt(strs[1]);
            int k = Integer.parseInt(strs[2]);

            int res = solution(m, n, k);
            System.out.println(res);
        }
    }

    public static int solution(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];

        dfs(visited, 0, 0, k);
//        bfs(visited, 0, 0, k);

        return result;
    }

    private static void dfs(boolean[][] visited, int x, int y, int k) {
        visited[x][y] = true;
        result++;

        for (int i = 0; i < 4; i++) {
            int nextX = x + next[i][0];
            int nextY = y + next[i][1];

            if (nextX < 0 || nextX >= visited.length || nextY < 0 || nextY >= visited[0].length
                    || visited[nextX][nextY] || sum(nextX) + sum(nextY) > k) {
                continue;
            }
            dfs(visited, nextX, nextY, k);
        }
    }

    private static void bfs(boolean[][] visited, int x, int y, int k) {
        visited[x][y] = true;
        result++;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        queue.offer(y);

        while (!queue.isEmpty()) {
            int tempX = queue.poll();
            int tempY = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = tempX + next[i][0];
                int nextY = tempY + next[i][1];
                if (nextX < 0 || nextX >= visited.length || nextY < 0 || nextY >= visited[0].length
                        || visited[nextX][nextY] || sum(nextX) + sum(nextY) > k) {
                    continue;
                }
                visited[nextX][nextY] = true;
                result++;
                queue.offer(nextX);
                queue.offer(nextY);
            }
        }
    }

    private static int sum(int i) {
        int sum = 0;
        do {
            sum += i % 10;
        } while ((i = i / 10) > 0);
        return sum;
    }

}
